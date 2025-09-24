package app.gritlog.user.valueobject

import app.gritlog.ValueObject

enum class Role: ValueObject {
    // 選手
    PLAYER,
    // 顧問
    ADVISOR,
    // コーチ
    COACH,
    // マネージャー
    TEAM_MANAGER
}