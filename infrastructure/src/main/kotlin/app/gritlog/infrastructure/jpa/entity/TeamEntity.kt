package app.gritlog.infrastructure.jpa.entity

import app.gritlog.application.TeamDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "team")
class TeamEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name = "team_name", nullable = false, length = 100)
    var teamName: String,
    @Column(name = "sex", nullable = false, length = 16)
    var sex: String,
    @Column(name = "team_category", nullable = false, length = 32)
    var teamCategory: String,
    @Column(name = "representative_id", nullable = false)
    var representativeId: Long,
    @Column(name = "players_count", nullable = false)
    var playersCount: Int,
    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now(),
) {
    internal fun toDto() =
        TeamDto(
            id = requireNotNull(id),
            teamName = teamName,
            sex = sex,
            teamCategory = teamCategory,
            representativeId = representativeId,
            playersCount = playersCount,
            createdAt = createdAt,
            updatedAt = updatedAt,
        )
}
