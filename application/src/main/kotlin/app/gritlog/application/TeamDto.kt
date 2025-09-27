package app.gritlog.application

import java.time.LocalDateTime

data class TeamDto(
    val id: Long?,
    val teamName: String,
    val sex: String,
    val teamCategory: String,
    val representativeId: Long,
    val playersCount: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    // 排他が必要ならリポジトリで詰める
    val updatedAtEpochMillis: Long? = null,
)
