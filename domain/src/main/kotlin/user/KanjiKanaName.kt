package app.gritlog.user

import app.gritlog.ValueObject

data class KanjiKanaName(val value: String): ValueObject {

    init {
        // 全角文字、半角スペース、全角スペースのみ許可
    }
}
