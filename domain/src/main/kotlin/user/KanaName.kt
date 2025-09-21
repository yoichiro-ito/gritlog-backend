package app.gritlog.user

import app.gritlog.ValueObject

data class KanaName(val value: String): ValueObject {
    init {
        // 全角カタカナ、半角スペース、全角スペースのみ許可
    }
}
