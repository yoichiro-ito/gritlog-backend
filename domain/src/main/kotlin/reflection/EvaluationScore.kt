package app.gritlog.reflection

import app.gritlog.ValueObject

data class EvaluationScore(val value: Int) : ValueObject {
    init {
        // 5段階評価
        require(1 <= value && value <= 5) {}
    }
}
