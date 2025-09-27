package app.gritlog.application.account

interface IAccountRepository {
    fun findById(id: Long): AccountDto?

    fun findByLoginId(loginId: String): AccountDto?

    fun findAll(limit: Long = 100): List<AccountDto>

    fun existsById(id: Long): Boolean
}
