package app.gritlog.domain.goal

import app.gritlog.domain.DomainEntity
import app.gritlog.domain.goal.valueobject.GoalCategory

class SubGoal(
    override var id: Long?,
    val goalId: Long,
    val goalCategory: GoalCategory,
    val content: String,
    val actionPlan: ActionPlan,
) : DomainEntity<Long>(id)
