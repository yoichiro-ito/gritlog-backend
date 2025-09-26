package jpa.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "reflection")
class ReflectionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    var account: AccountEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_goal_id", nullable = false)
    var subGoal: SubGoalEntity,

    @Column(name = "evaluation_score", nullable = false)
    var evaluationScore: Int,

    @Column(length = 1000)
    var comment: String? = null,

    @Column(name = "is_public", nullable = false)
    var isPublic: Boolean,

    @Column(name = "created_at", insertable = false, updatable = false)
    var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at", insertable = false, updatable = false)
    var updatedAt: LocalDateTime? = null
) {
    @OneToMany(mappedBy = "reflection", fetch = FetchType.LAZY)
    var comments: MutableList<CommentEntity> = mutableListOf()
}
