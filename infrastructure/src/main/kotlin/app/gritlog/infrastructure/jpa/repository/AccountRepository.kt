package app.gritlog.infrastructure.jpa.repository

import app.gritlog.application.account.AccountDto
import app.gritlog.application.account.IAccountRepository
import app.gritlog.infrastructure.jpa.entity.QAccountEntity.accountEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class AccountRepository(
    private val query: JPAQueryFactory,
) : IAccountRepository {
    override fun findById(id: Long): AccountDto? =
        query.selectFrom(accountEntity)
            .where(accountEntity.id.eq(id))
            .fetchOne()
            ?.toDto()

    override fun findByLoginId(loginId: String): AccountDto? =
        query.selectFrom(accountEntity)
            .where(accountEntity.loginId.eq(loginId))
            .fetchOne()
            ?.toDto()

    override fun findAll(limit: Long): List<AccountDto> =
        query.selectFrom(accountEntity)
            .orderBy(accountEntity.id.desc())
            .limit(limit)
            .fetch()
            .map { it.toDto() }

    override fun existsById(id: Long): Boolean {
        TODO("Not yet implemented")
    }
}
