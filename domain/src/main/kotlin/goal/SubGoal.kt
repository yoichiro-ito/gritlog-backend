package app.gritlog.goal

import app.gritlog.DomainEntity

class SubGoal(
    override var id: Long?,
    val goalId: Long,
    val goalCategory: GoalCategory,
    val content: String,
): DomainEntity<Long>(id) {
}