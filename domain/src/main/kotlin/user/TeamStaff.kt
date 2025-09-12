package app.gritlog.user

import app.gritlog.DomainEntity

class TeamStaff(
    override var id: Long?,
    val nameKanjikana: KanjiKanaName,
    val nameKana: KanaName,
    val nameAlphabet: AlphabetName?,
    val staffRole: StaffRole,
) : DomainEntity<Long>(id){
}