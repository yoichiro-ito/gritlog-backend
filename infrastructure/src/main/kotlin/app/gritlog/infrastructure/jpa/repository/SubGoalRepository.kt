package app.gritlog.infrastructure.jpa.repository

import app.gritlog.application.goal.ISubGoalRepository
import app.gritlog.application.goal.SubGoalDto
import com.querydsl.jpa.impl.JPAQueryFactory
import jpa.entity.QSubGoalEntity.subGoalEntity
import org.springframework.stereotype.Repository

@Repository
class SubGoalRepository(
    private val query: JPAQueryFactory,
) : ISubGoalRepository {
    override fun findById(id: Long): SubGoalDto? = query.selectFrom(subGoalEntity).where(subGoalEntity.id.eq(id)).fetchOne()?.toDto()

    override fun findAllByGoal(goalId: Long): List<SubGoalDto> =
        query.selectFrom(subGoalEntity)
            .where(subGoalEntity.goal.id.eq(goalId))
            .orderBy(subGoalEntity.orderNo.asc())
            .fetch()
            .map { it.toDto() }
}
