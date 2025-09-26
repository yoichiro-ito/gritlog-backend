package jpa.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import goal.GoalDto
import goal.IGoalRepository
import jpa.entity.QGoalEntity.goalEntity
import org.springframework.stereotype.Repository

@Repository
class GoalRepository(
    private val query: JPAQueryFactory,
) : IGoalRepository {
    override fun findById(id: Long): GoalDto? = query.selectFrom(goalEntity).where(goalEntity.id.eq(id)).fetchOne()?.toDto()

    override fun findByAccount(
        accountId: Long,
        limit: Long,
    ): List<GoalDto> =
        query.selectFrom(goalEntity)
            .where(goalEntity.account.id.eq(accountId))
            .orderBy(goalEntity.id.desc())
            .limit(limit)
            .fetch()
            .map { it.toDto() }
}
