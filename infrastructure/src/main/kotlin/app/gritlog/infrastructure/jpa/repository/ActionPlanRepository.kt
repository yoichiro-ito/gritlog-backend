package app.gritlog.infrastructure.jpa.repository

import app.gritlog.application.goal.ActionPlanDto
import app.gritlog.application.goal.IActionPlanRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import jpa.entity.QActionPlanEntity.actionPlanEntity
import org.springframework.stereotype.Repository

@Repository
class ActionPlanRepository(
    private val query: JPAQueryFactory,
) : IActionPlanRepository {
    override fun findById(id: Long): ActionPlanDto? =
        query.selectFrom(actionPlanEntity).where(actionPlanEntity.id.eq(id)).fetchOne()?.toDto()

    override fun findAllBySubGoal(subGoalId: Long): List<ActionPlanDto> =
        query.selectFrom(actionPlanEntity)
            .where(actionPlanEntity.subGoal.id.eq(subGoalId))
            .fetch()
            .map { it.toDto() }
}
