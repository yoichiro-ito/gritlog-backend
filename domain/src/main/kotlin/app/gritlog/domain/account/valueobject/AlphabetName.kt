package app.gritlog.domain.account.valueobject

import app.gritlog.domain.ValueObject

data class AlphabetName(val value: String) : ValueObject {
    init {
        // 半角英数字、半角スペースのみ許可
    }
}
