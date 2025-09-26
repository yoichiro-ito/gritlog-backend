package account

interface IAccountRoleRepository {
    fun findByIds(accountId: Long, roleId: Long): AccountRoleDto?
    fun findRolesByAccount(accountId: Long): List<RoleDto>
}