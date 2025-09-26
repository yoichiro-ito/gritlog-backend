package app.gritlog.user.valueobject

import app.gritlog.ValueObject

enum class DominantArm : ValueObject {
    // 右利き
    RIGHT_HANDED,

    // 左利き
    LEFT_HANDED,

    // 両利き
    AMBIDEXTROUS,
}
