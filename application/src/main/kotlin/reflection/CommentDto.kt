package reflection

import java.time.LocalDateTime

data class CommentDto(
    val id: Long,
    val reflectionId: Long,
    val authorAccountId: Long,
    val parentCommentId: Long?,
    val body: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
)
