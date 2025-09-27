package app.gritlog.domain.goal.valueobject

import app.gritlog.domain.ValueObject

enum class Status : ValueObject {
    // 作成中
    IN_PROGRESS,

    // 確定
    FIXED,

    // 完了
    DONE,
}
