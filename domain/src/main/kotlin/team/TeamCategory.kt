package app.gritlog.team

import app.gritlog.ValueObject

enum class TeamCategory: ValueObject {
    // 中学
    JUNIOR_HIGH_SCHOOL,
    // 高校
    HIGH_SCHOOL,
    // 大学
    UNIVERSITY,
    // 一般・社会人
    GENERAL
}