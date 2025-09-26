package app.gritlog.user

import app.gritlog.DomainEntity
import app.gritlog.common.valueobject.Sex
import app.gritlog.user.valueobject.*
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
    ) :DomainEntity<Int>(id) , Account {
}