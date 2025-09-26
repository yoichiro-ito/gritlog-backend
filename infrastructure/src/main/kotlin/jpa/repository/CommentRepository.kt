package jpa.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import jpa.entity.QCommentEntity.commentEntity
import org.springframework.stereotype.Repository
import reflection.CommentDto
import reflection.ICommentRepository

@Repository
class CommentRepository(
    private val query: JPAQueryFactory,
) : ICommentRepository {
    override fun findById(id: Long): CommentDto? = query.selectFrom(commentEntity).where(commentEntity.id.eq(id)).fetchOne()?.toDto()

    override fun findAllByReflection(reflectionId: Long): List<CommentDto> =
        query.selectFrom(commentEntity)
            .where(commentEntity.reflection.id.eq(reflectionId))
            .orderBy(commentEntity.createdAt.asc())
            .fetch()
            .map { it.toDto() }
}
