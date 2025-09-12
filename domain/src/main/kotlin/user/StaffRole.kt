package app.gritlog.user

import app.gritlog.ValueObject

enum class StaffRole: ValueObject {
    // 顧問
    ADVISOR,
    // コーチ
    COACH,
    // マネージャー
    TEAM_MANAGER
}