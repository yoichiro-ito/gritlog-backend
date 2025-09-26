package team

interface ITeamRepository {
    fun findById(id: Long): TeamDto?

    fun findByRepresentiveId(representiveId: Long): TeamDto?
}
