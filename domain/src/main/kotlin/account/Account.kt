package app.gritlog.user

import app.gritlog.user.valueobject.*
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