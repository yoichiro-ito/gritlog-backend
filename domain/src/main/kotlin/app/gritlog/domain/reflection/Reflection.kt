package app.gritlog.domain.reflection

import app.gritlog.domain.DomainEntity
import app.gritlog.domain.reflection.valueobject.EvaluationScore
import java.time.LocalDateTime

class Reflection(
    override var id: Long?,
    val goalId: Long,
    val targetSubGoalId: Long?,
    val selfEvaluationScore: EvaluationScore,
    val evaluationComment: String,
    val isPublic: Boolean,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) : DomainEntity<Long>(id)
