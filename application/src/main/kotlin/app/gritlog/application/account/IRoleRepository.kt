package app.gritlog.application.account

interface IRoleRepository {
    fun findById(id: Long): app.gritlog.application.account.RoleDto?

    fun findAll(limit: Long = 100): List<app.gritlog.application.account.RoleDto>
}
