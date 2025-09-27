package app.gritlog.domain.account.valueobject

import app.gritlog.domain.ValueObject

enum class Position : ValueObject {
    GOAL_KEEPER,
    PIVOT,
    LEFT_WING,
    RIGHT_WING,
    LEFT_BACK,
    CENTER_BACK,
    RIGHT_BACK,
}
