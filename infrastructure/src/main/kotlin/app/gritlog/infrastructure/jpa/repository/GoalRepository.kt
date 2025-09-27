package app.gritlog.infrastructure.jpa.repository

import app.gritlog.application.goal.GoalDto
import app.gritlog.application.goal.IGoalRepository
import app.gritlog.infrastructure.jpa.entity.QGoalEntity.goalEntity
import com.querydsl.jpa.impl.JPAQueryFactory
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
