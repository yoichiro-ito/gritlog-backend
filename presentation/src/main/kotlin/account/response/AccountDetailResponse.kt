package app.gritlog.user.response

import app.gritlog.goal.valueobject.Status

data class AccountDetailResponse(
    val id: Long,
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
)