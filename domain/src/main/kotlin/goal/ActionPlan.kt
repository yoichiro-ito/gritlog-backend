package app.gritlog.goal

import app.gritlog.DomainEntity

class ActionPlan(
    override var id: Long?,
    val subGoalId: Long,
    val planWhen: String,
    val planWhat: String,
    val planHow: String
): DomainEntity<Long>(id) {

}