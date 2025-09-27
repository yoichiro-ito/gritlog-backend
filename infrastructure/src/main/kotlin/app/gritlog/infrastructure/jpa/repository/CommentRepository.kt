package app.gritlog.infrastructure.jpa.repository

import app.gritlog.application.reflection.ICommentRepository
import app.gritlog.infrastructure.jpa.entity.QCommentEntity.commentEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class CommentRepository(
    private val query: JPAQueryFactory,
) : ICommentRepository {
    override fun findById(id: Long): app.gritlog.application.reflection.CommentDto? =
        query.selectFrom(commentEntity).where(commentEntity.id.eq(id)).fetchOne()?.toDto()

    override fun findAllByReflection(reflectionId: Long): List<app.gritlog.application.reflection.CommentDto> =
        query.selectFrom(commentEntity)
            .where(commentEntity.reflection.id.eq(reflectionId))
            .orderBy(commentEntity.createdAt.asc())
            .fetch()
            .map { it.toDto() }
}
