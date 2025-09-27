package app.gritlog.application.goal

import java.time.LocalDateTime

data class SubGoalDto(
    val id: Long,
    val goalId: Long,
    val category: String,
    val title: String,
    val description: String?,
    val orderNo: Int,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
)
