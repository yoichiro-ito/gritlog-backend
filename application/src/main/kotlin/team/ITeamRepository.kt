package team

import app.gritlog.team.Team

interface ITeamRepository {
    fun findById(id: Long): TeamDto?
    fun findByRepresentiveId(representiveId: Long): TeamDto?
}