package app.gritlog.goal

import app.gritlog.DomainEntity
import app.gritlog.goal.valueobject.Status

class Goal(
    override var id: Long?,
    val playerId: Long,
    val status: Status,
    val mainGoal: String,
    val subGoal1: SubGoal,
    val subGoal2: SubGoal,
    val subGoal3: SubGoal,
) : DomainEntity<Long>(id)
