package account


interface IRoleRepository {
    fun findById(id: Long): RoleDto?
    fun findAll(limit: Long = 100): List<RoleDto>
}