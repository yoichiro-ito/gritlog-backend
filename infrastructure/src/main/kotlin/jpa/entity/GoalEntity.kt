package jpa.entity

import goal.GoalDto
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "goal")
class GoalEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    var account: AccountEntity,

    @Column(nullable = false, length = 32)
    var status: String,

    @Column(name = "main_goal_title", nullable = false, length = 100)
    var mainGoalTitle: String,

    @Column(name = "main_goal_description", length = 200)
    var mainGoalDescription: String? = null,

    @Column(name = "start_date")
    var startDate: LocalDate? = null,

    @Column(name = "end_date")
    var endDate: LocalDate? = null,

    @Column(name = "created_at", insertable = false, updatable = false)
    var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at", insertable = false, updatable = false)
    var updatedAt: LocalDateTime? = null
) {
    @OneToMany(mappedBy = "goal", fetch = FetchType.LAZY, cascade = [])
    var subGoals: MutableList<SubGoalEntity> = mutableListOf()

    internal fun toDto() = GoalDto(
        id = requireNotNull(id),
        accountId = requireNotNull(account.id),
        status = status,
        mainGoalTitle = mainGoalTitle,
        mainGoalDescription = mainGoalDescription,
        startDate = startDate,
        endDate = endDate,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}
