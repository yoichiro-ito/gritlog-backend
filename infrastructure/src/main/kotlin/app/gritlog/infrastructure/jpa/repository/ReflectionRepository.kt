package app.gritlog.infrastructure.jpa.repository

import app.gritlog.application.reflection.IReflectionRepository
import app.gritlog.application.reflection.ReflectionDto
import app.gritlog.application.reflection.ReflectionSearchForm
import app.gritlog.infrastructure.jpa.entity.QReflectionEntity.reflectionEntity
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class ReflectionRepository(
    private val query: JPAQueryFactory,
) : IReflectionRepository {
    override fun findById(id: Long): ReflectionDto? =
        query.selectFrom(reflectionEntity)
            .where(reflectionEntity.id.eq(id))
            .fetchOne()
            ?.toDto()

    override fun search(
        cond: ReflectionSearchForm,
        limit: Long,
    ): List<ReflectionDto> =
        query.selectFrom(reflectionEntity)
            .where(
                listOfNotNull(
                    cond.subGoalId?.let { reflectionEntity.subGoal.id.eq(it) },
                    cond.isPublic?.let { reflectionEntity.isPublic.eq(it) },
                    cond.minScore?.let { reflectionEntity.evaluationScore.goe(it) },
                    cond.maxScore?.let { reflectionEntity.evaluationScore.loe(it) },
                    cond.from?.let { reflectionEntity.createdAt.goe(it) },
                    cond.to?.let { reflectionEntity.createdAt.loe(it) },
                ).toAnd(),
            )
            .orderBy(reflectionEntity.createdAt.desc())
            .limit(limit)
            .fetch()
            .map { it.toDto() }

    private fun List<BooleanExpression>.toAnd(): BooleanExpression? = this.reduceOrNull { acc, exp -> acc.and(exp) }
}
