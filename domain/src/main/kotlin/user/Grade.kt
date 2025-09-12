package app.gritlog.user

import app.gritlog.ValueObject

data class Grade(val value: Int) : ValueObject {
        init {
            require(1 <= value && value <= 3) {}
        }
}
