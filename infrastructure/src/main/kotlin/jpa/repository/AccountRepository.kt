package jpa.repository

import account.AccountDto
import account.IAccountRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import jpa.entity.QAccountEntity.accountEntity
import org.springframework.stereotype.Repository

@Repository
class AccountRepository(
    private val query: JPAQueryFactory
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


}
