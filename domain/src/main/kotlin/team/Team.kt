package app.gritlog.team

import app.gritlog.DomainEntity

class Team(
    override var id: Long?
) : DomainEntity<Long>(id)