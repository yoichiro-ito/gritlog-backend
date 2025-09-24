package app.gritlog.goal

import app.gritlog.DomainEntity
import app.gritlog.goal.valueobject.GoalCategory

class SubGoal(
    override var id: Long?,
    val goalId: Long,
    val goalCategory: GoalCategory,
    val content: String,
    val actionPlan: ActionPlan,
): DomainEntity<Long>(id) {
}