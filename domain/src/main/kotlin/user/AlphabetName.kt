package app.gritlog.user

import app.gritlog.ValueObject

data class AlphabetName(val value: String): ValueObject {
    init {
        // 半角英数字、半角スペースのみ許可
    }
}
