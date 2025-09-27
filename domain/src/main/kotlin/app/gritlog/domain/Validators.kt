package app.gritlog.domain

class Validators {
    // 必須項目
    fun requireNotBlank(
        name: String,
        s: String,
    ) {
        require(s.isNotBlank()) { "$name は入力必須項目です。" }
    }

    // 文字列長
    fun requireLength(
        name: String,
        s: String,
        min: Int,
        max: Int,
    ) {
        require(s.length in min..max) { "${name}は$min～${max}文字である必要があります。現在：${s.length}文字" }
    }

    // 数値範囲(Int)
    fun requireIntRange(
        name: String,
        v: Int,
        min: Int,
        max: Int,
    ) {
        require(v in min..max) { "${name}は$min～${max}の範囲内である必要があります。現在：$v" }
    }
}
