package app.gritlog.infrastructure.jpa.repository

import app.gritlog.application.ITeamRepository
import app.gritlog.application.TeamDto
import app.gritlog.application.TeamSearchForm
import com.querydsl.jpa.impl.JPAQueryFactory
import jpa.entity.QTeamEntity

class TeamRepository(
    private val query: JPAQueryFactory,
) : ITeamRepository {
    override fun findById(id: Long): TeamDto? =
        query.selectFrom(QTeamEntity.teamEntity)
            .where(QTeamEntity.teamEntity.id.eq(id))
            .fetchOne()
            ?.toDto()

    override fun findByRepresentativeId(representativeId: Long): TeamDto? =
        query.selectFrom(QTeamEntity.teamEntity)
            .where(QTeamEntity.teamEntity.representativeId.eq(representativeId))
            .fetchOne()
            ?.toDto()

    override fun search(form: TeamSearchForm): List<TeamDto> {
        TODO("Not yet implemented")
    }

    override fun insert(newTeam: TeamDto): Long {
        TODO("Not yet implemented")
    }

    override fun update(replacement: TeamDto) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun existsByUniqueKey(teamName: String, teamCategory: Any, sex: Any?, excludeId: Long?): Boolean {
        TODO("Not yet implemented")
    }
}
