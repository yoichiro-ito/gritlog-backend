package app.gritlog.goal

import app.gritlog.DomainEntity

class Goal(
    override var id: Long?,
    val playerId: Long,
    val status: Status,
    val mainGoal: String,
    val subGoal1: String,
    val subGoal2: String,
    val subGoal3: String,
    val subGoal4: String?,
    val subGoal5: String?,
    val actionplan1: String,
    val actionplan2: String,
    val actionplan3: String,
    val actionplan4: String?,
    val actionplan5: String?,
): DomainEntity<Long>(id)