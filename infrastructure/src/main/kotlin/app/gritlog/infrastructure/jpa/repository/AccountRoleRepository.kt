package app.gritlog.infrastructure.jpa.repository

import app.gritlog.application.account.IAccountRoleRepository
import app.gritlog.infrastructure.jpa.entity.QAccountRoleEntity.accountRoleEntity
import app.gritlog.infrastructure.jpa.entity.QRoleEntity.roleEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class AccountRoleRepository(
    private val query: JPAQueryFactory,
) : IAccountRoleRepository {
    override fun findByIds(
        accountId: Long,
        roleId: Long,
    ): app.gritlog.application.account.AccountRoleDto? =
        query.selectFrom(accountRoleEntity)
            .where(
                accountRoleEntity.id.accountId.eq(accountId)
                    .and(accountRoleEntity.id.roleId.eq(roleId)),
            )
            .fetchOne()
            ?.toDto()

    override fun findRolesByAccount(accountId: Long): List<app.gritlog.application.account.RoleDto> =
        query.select(roleEntity)
            .from(accountRoleEntity)
            .join(accountRoleEntity.role, roleEntity)
            .where(accountRoleEntity.id.accountId.eq(accountId))
            .fetch()
            .map { it.toDto() }
}
