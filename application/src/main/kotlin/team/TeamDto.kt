package team

import java.time.LocalDateTime


data class TeamDto(
    val id: Long?,
    val teamName: String,
    val sex: String,
    val teamCategory: String,
    val representiveId: Long,
    val playersCount: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)