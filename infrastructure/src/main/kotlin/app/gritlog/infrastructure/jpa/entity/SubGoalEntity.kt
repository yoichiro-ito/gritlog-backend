package app.gritlog.infrastructure.jpa.entity

import app.gritlog.application.goal.SubGoalDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "sub_goal")
class SubGoalEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_id", nullable = false)
    var goal: GoalEntity,
    @Column(nullable = false, length = 32)
    var category: String,
    @Column(nullable = false, length = 100)
    var title: String,
    @Column(length = 200)
    var description: String? = null,
    @Column(name = "order_no", nullable = false)
    var orderNo: Int = 0,
    @Column(name = "created_at", insertable = false, updatable = false)
    var createdAt: LocalDateTime? = null,
    @Column(name = "updated_at", insertable = false, updatable = false)
    var updatedAt: LocalDateTime? = null,
) {
    @OneToMany(mappedBy = "subGoal", fetch = FetchType.LAZY)
    var actionPlans: MutableList<ActionPlanEntity> = mutableListOf()

    @OneToMany(mappedBy = "subGoal", fetch = FetchType.LAZY)
    var reflections: MutableList<ReflectionEntity> = mutableListOf()

    internal fun toDto() =
        SubGoalDto(
            id = requireNotNull(id),
            goalId = requireNotNull(goal.id),
            category = category,
            title = title,
            description = description,
            orderNo = orderNo,
            createdAt = createdAt,
            updatedAt = updatedAt,
        )
}
