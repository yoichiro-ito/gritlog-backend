package app.gritlog.application.reflection

import java.time.LocalDateTime

data class ReflectionSearchForm(
    val subGoalId: Long? = null,
    val isPublic: Boolean? = null,
    val minScore: Int? = null,
    val maxScore: Int? = null,
    val from: LocalDateTime? = null,
    val to: LocalDateTime? = null,
)
