package app.gritlog.team

import app.gritlog.DomainEntity
import app.gritlog.common.valueobject.Sex

class Team(
    override var id: Long?,
    val teamName: String,
    val sex: Sex,
    val teamCategory: TeamCategory,
    val representiveId: Long,
    val playersCount: Int,
) : DomainEntity<Long>(id)
