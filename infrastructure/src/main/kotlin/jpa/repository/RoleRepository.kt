package jpa.repository

import account.IRoleRepository
import account.RoleDto
import jpa.entity.QRoleEntity.roleEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class RoleRepository(
    private val query: JPAQueryFactory
) : IRoleRepository {
    override fun findById(id: Long): RoleDto? =
        query.selectFrom(roleEntity).where(roleEntity.id.eq(id)).fetchOne()?.toDto()

    override fun findAll(limit: Long): List<RoleDto> =
        query.selectFrom(roleEntity).orderBy(roleEntity.id.desc()).limit(limit).fetch().map { it.toDto() }
}
