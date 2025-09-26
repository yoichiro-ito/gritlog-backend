package goal

import java.time.LocalDateTime

data class ActionPlanDto(
    val id: Long,
    val subGoalId: Long,
    val planWhen: String,
    val planWhat: String,
    val planHow: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
)