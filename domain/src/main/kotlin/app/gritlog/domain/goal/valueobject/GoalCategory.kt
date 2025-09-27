package app.gritlog.domain.goal.valueobject

import app.gritlog.domain.ValueObject

enum class GoalCategory : ValueObject {
    TECHNICAL,
    PHYSICAL,
    TACTICAL,
    MENTAL,
    TEAMWORK,
}
