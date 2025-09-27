package app.gritlog.application.account

interface IAccountRoleRepository {
    fun findByIds(
        accountId: Long,
        roleId: Long,
    ): app.gritlog.application.account.AccountRoleDto?

    fun findRolesByAccount(accountId: Long): List<app.gritlog.application.account.RoleDto>
}
