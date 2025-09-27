package app.gritlog.domain.account.valueobject

import app.gritlog.domain.ValueObject

data class Grade(val value: Int) : ValueObject {
    init {
        require(1 <= value && value <= 3) {}
    }
}
