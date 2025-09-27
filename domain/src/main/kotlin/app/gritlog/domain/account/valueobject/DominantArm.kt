package app.gritlog.domain.account.valueobject

import app.gritlog.domain.ValueObject

enum class DominantArm : ValueObject {
    // 右利き
    RIGHT_HANDED,

    // 左利き
    LEFT_HANDED,

    // 両利き
    AMBIDEXTROUS,
}
