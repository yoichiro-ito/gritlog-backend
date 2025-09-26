package goal

import java.time.LocalDate
import java.time.LocalDateTime

data class GoalDto(
    val id: Long,
    val accountId: Long,
    val status: String,
    val mainGoalTitle: String,
    val mainGoalDescription: String?,
    val startDate: LocalDate?,
    val endDate: LocalDate?,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
)
