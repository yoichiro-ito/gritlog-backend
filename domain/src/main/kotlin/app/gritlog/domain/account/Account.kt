package app.gritlog.domain.account

import app.gritlog.domain.account.valueobject.AlphabetName
import app.gritlog.domain.account.valueobject.Email
import app.gritlog.domain.account.valueobject.KanaName
import app.gritlog.domain.account.valueobject.KanjiKanaName
import app.gritlog.domain.account.valueobject.LoginId
import app.gritlog.domain.account.valueobject.Role
import java.time.LocalDateTime

interface Account {
    val id: Int?
    val teamId: Int
    val nameKanjikana: KanjiKanaName
    val nameKana: KanaName
    val nameAlphabet: AlphabetName?
    val role: Role
    val loginId: LoginId
    val email: Email
    val password: String
    val loginFailedAt: LocalDateTime
    val lockedNologinAt: LocalDateTime?
    val lockedAt: LocalDateTime?
    val deletedAt: LocalDateTime?
}
