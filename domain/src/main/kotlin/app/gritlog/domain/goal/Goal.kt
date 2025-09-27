package app.gritlog.domain.goal

import app.gritlog.domain.DomainEntity
import app.gritlog.domain.goal.valueobject.Status

class Goal(
    override var id: Long?,
    val playerId: Long,
    val status: Status,
    val mainGoal: String,
    val subGoal1: app.gritlog.domain.goal.SubGoal,
    val subGoal2: app.gritlog.domain.goal.SubGoal,
    val subGoal3: app.gritlog.domain.goal.SubGoal,
) : DomainEntity<Long>(id)
