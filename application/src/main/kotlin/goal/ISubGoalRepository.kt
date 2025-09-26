package goal

interface ISubGoalRepository {
    fun findById(id: Long): SubGoalDto?
    fun findAllByGoal(goalId: Long): List<SubGoalDto>
}