package goal

interface IGoalRepository {
    fun findById(id: Long): GoalDto?
    fun findByAccount(accountId: Long, limit: Long = 100): List<GoalDto>
}