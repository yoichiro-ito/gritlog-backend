package app.gritlog.domain.account.valueobject

import app.gritlog.domain.ValueObject

enum class Role : ValueObject {
    // 選手
    PLAYER,

    // 顧問
    ADVISOR,

    // コーチ
    COACH,

    // マネージャー
    TEAM_MANAGER,
}
