package app.gritlog.domain.account.valueobject

import app.gritlog.domain.ValueObject

data class KanaName(val value: String) : ValueObject {
    init {
        // 全角カタカナ、半角スペース、全角スペースのみ許可
    }
}
