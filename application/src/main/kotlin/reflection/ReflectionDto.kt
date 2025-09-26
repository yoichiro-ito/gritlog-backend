package reflection

import java.time.LocalDateTime

data class ReflectionDto(
    val id: Long,
    val accountId: Long,
    val subGoalId: Long,
    val evaluationScore: Int,
    val comment: String?,
    val isPublic: Boolean,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
)
