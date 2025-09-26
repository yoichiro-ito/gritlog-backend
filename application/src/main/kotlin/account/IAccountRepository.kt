package account

interface IAccountRepository {
    fun findById(id: Long): AccountDto?

    fun findByLoginId(loginId: String): AccountDto?

    fun findAll(limit: Long = 100): List<AccountDto>
}
