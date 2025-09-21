package app.gritlog.goal

import app.gritlog.DomainEntity

class Goal(
    override var id: Long?,
    val playerId: Long,
    val status: Status,
    val mainGoal: String,
    val subGoal1: SubGoal,
    val subGoal2: SubGoal,
    val subGoal3: SubGoal,
    val actionplan1: String,
    val actionplan2: String,
    val actionplan3: String,
): DomainEntity<Long>(id)