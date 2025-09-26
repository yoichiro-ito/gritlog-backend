package jpa.repository

import account.AccountRoleDto
import account.IAccountRoleRepository
import account.RoleDto
import com.querydsl.jpa.impl.JPAQueryFactory
import jpa.entity.QAccountRoleEntity.accountRoleEntity
import jpa.entity.QRoleEntity.roleEntity
import org.springframework.stereotype.Repository

@Repository
class AccountRoleRepository(
    private val query: JPAQueryFactory,
) : IAccountRoleRepository {
    override fun findByIds(
        accountId: Long,
        roleId: Long,
    ): AccountRoleDto? =
        query.selectFrom(accountRoleEntity)
            .where(
                accountRoleEntity.id.accountId.eq(accountId)
                    .and(accountRoleEntity.id.roleId.eq(roleId)),
            )
            .fetchOne()
            ?.toDto()

    override fun findRolesByAccount(accountId: Long): List<RoleDto> =
        query.select(roleEntity)
            .from(accountRoleEntity)
            .join(accountRoleEntity.role, roleEntity)
            .where(accountRoleEntity.id.accountId.eq(accountId))
            .fetch()
            .map { it.toDto() }
}
