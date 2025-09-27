package app.gritlog.domain.goal

import app.gritlog.domain.DomainEntity

class ActionPlan(
    override var id: Long?,
    val subGoalId: Long,
    val planWhen: String,
    val planWhat: String,
    val planHow: String,
) : DomainEntity<Long>(id)
