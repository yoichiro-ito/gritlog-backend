package app.gritlog.application

interface ITeamRepository {
    fun insert(newTeam: TeamDto): Long

    fun search(form: TeamSearchForm): List<TeamDto>

    fun findById(id: Long): TeamDto?

    fun findByRepresentativeId(representativeId: Long): TeamDto?

    fun update(replacement: TeamDto)

    fun delete(id: Long)

    fun existsByUniqueKey(
        teamName: String,
        teamCategory: Any,
        sex: Any? = null,
        excludeId: Long? = null,
    ): Boolean
}
