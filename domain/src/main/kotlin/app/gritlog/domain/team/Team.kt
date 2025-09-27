package app.gritlog.domain.team

import app.gritlog.domain.DomainEntity
import app.gritlog.domain.team.valueobject.TeamCategory
import app.gritlog.domain.valueobject.Sex

class Team(
    override var id: Long?,
    val teamName: String,
    val sex: Sex,
    val teamCategory: TeamCategory,
    val representativeId: Long,
    val playersCount: Int,
) : DomainEntity<Long>(id)
