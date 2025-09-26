package jpa.entity

import goal.ActionPlanDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "action_plan")
class ActionPlanEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_goal_id", nullable = false)
    var subGoal: SubGoalEntity,
    @Column(name = "plan_when", nullable = false, length = 100)
    var planWhen: String,
    @Column(name = "plan_what", nullable = false, length = 100)
    var planWhat: String,
    @Column(name = "plan_how", nullable = false, length = 200)
    var planHow: String,
    @Column(name = "created_at", insertable = false, updatable = false)
    var createdAt: LocalDateTime? = null,
    @Column(name = "updated_at", insertable = false, updatable = false)
    var updatedAt: LocalDateTime? = null,
) {
    internal fun toDto() =
        ActionPlanDto(
            id = requireNotNull(id),
            subGoalId = requireNotNull(subGoal.id),
            planWhen = planWhen,
            planWhat = planWhat,
            planHow = planHow,
            createdAt = createdAt,
            updatedAt = updatedAt,
        )
}
