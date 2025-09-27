package app.gritlog.domain.goal.valueobject

import app.gritlog.domain.DomainEntity
import java.time.LocalDateTime

class Comment(
    override var id: Long?,
    val goalId: Long,
    val replyToReflectionId: Long?,
    val replyToCommentId: Long?,
    val content: String,
    val createdAt: LocalDateTime,
    val createdBy: Long,
    val isDeleted: Boolean,
) : DomainEntity<Long>(id)
