package jpa.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import jpa.entity.QTeamEntity
import team.ITeamRepository
import team.TeamDto

class TeamRepository(
    private val query: JPAQueryFactory,
) : ITeamRepository {
    override fun findById(id: Long): TeamDto? =
        query.selectFrom(QTeamEntity.teamEntity)
            .where(QTeamEntity.teamEntity.id.eq(id))
            .fetchOne()
            ?.toDto()

    override fun findByRepresentiveId(representiveId: Long): TeamDto? =
        query.selectFrom(QTeamEntity.teamEntity)
            .where(QTeamEntity.teamEntity.representiveId.eq(representiveId))
            .fetchOne()
            ?.toDto()
}
