package app.gritlog.user

import app.gritlog.DomainEntity

class Player(
    override var id: Long?,
    val teamId: Long,
    val nameKanjikana: KanjiKanaName,
    val nameKana: KanaName,
    val nameAlphabet: AlphabetName?,
    val sex: Sex,
    val grade: Grade,
    val position: Position,
    val dominantArm: DominantArm,
    val height: Int?,
    val weight: Int?,
    ) :DomainEntity<Long>(id){
}