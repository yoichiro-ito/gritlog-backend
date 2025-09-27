package app.gritlog.application.goal

interface IActionPlanRepository {
    fun findById(id: Long): ActionPlanDto?

    fun findAllBySubGoal(subGoalId: Long): List<ActionPlanDto>
}
