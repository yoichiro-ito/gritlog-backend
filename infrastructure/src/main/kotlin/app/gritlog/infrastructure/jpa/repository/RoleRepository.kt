package app.gritlog.infrastructure.jpa.repository

import app.gritlog.infrastructure.jpa.entity.QRoleEntity.roleEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class RoleRepository(
    private val query: JPAQueryFactory,
) : app.gritlog.application.account.IRoleRepository {
    override fun findById(id: Long): app.gritlog.application.account.RoleDto? =
        query.selectFrom(roleEntity).where(roleEntity.id.eq(id)).fetchOne()?.toDto()

    override fun findAll(limit: Long): List<app.gritlog.application.account.RoleDto> =
        query.selectFrom(roleEntity).orderBy(roleEntity.id.desc()).limit(limit).fetch().map { it.toDto() }
}
