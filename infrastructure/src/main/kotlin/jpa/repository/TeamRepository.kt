package jpa.repository

import app.gritlog.team.Team
import com.querydsl.jpa.impl.JPAQueryFactory
import jpa.entity.QAccountEntity
import jpa.entity.QTeamEntity
import team.ITeamRepository
import team.TeamDto
import jpa.entity.QTeamEntity.teamEntity

class TeamRepository(
    private val query: JPAQueryFactory
): ITeamRepository {


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