package app.gritlog.goal

import app.gritlog.DomainEntity
import java.time.LocalDateTime

class Comment(
    override var id: Long?,
    val goalId: Long,
    val replyToCommentId: Long?,
    val content: String,
    val createdAt: LocalDateTime,
    val createdBy: Long,
    val isDeleted: Boolean,
): DomainEntity<Long>(id)