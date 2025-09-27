package app.gritlog.domain.account

import app.gritlog.domain.DomainEntity
import app.gritlog.domain.account.valueobject.AlphabetName
import app.gritlog.domain.account.valueobject.DominantArm
import app.gritlog.domain.account.valueobject.Email
import app.gritlog.domain.account.valueobject.Grade
import app.gritlog.domain.account.valueobject.KanaName
import app.gritlog.domain.account.valueobject.KanjiKanaName
import app.gritlog.domain.account.valueobject.LoginId
import app.gritlog.domain.account.valueobject.Position
import app.gritlog.domain.account.valueobject.Role
import app.gritlog.domain.valueobject.Sex
import java.time.LocalDateTime

class Player(
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
    val sex: Sex,
    val grade: Grade,
    val position: Position,
    val dominantArm: DominantArm,
    val height: Int?,
    val weight: Int?,
) : DomainEntity<Int>(id), Account
