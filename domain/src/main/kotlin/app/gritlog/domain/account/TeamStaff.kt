package app.gritlog.user

import app.gritlog.domain.DomainEntity
import app.gritlog.domain.account.Account
import app.gritlog.domain.account.valueobject.AlphabetName
import app.gritlog.domain.account.valueobject.Email
import app.gritlog.domain.account.valueobject.KanaName
import app.gritlog.domain.account.valueobject.KanjiKanaName
import app.gritlog.domain.account.valueobject.LoginId
import app.gritlog.domain.account.valueobject.Role
import java.time.LocalDateTime

class TeamStaff(
    override var id: Int?,
    override val teamId: Int,
    override val nameKanjikana: KanjiKanaName,
    override val nameKana: KanaName,
    override val nameAlphabet: AlphabetName?,
    override val role: Role,
    override val loginId: LoginId,
    override val email: Email,
    override val loginFailedAt: LocalDateTime,
    override val password: String,
    override val deletedAt: LocalDateTime?,
    override val lockedAt: LocalDateTime?,
    override val lockedNologinAt: LocalDateTime?,
) : DomainEntity<Int>(id), Account
