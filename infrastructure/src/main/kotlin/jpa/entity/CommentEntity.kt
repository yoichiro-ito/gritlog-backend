package jpa.entity

import jakarta.persistence.*
import reflection.CommentDto
import java.time.LocalDateTime

@Entity
@Table(name = "comment")
class CommentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reflection_id", nullable = false)
    var reflection: ReflectionEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_account_id", nullable = false)
    var authorAccount: AccountEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_id")
    var parent: CommentEntity? = null,

    @Column(name = "body", nullable = false, length = 1000)
    var body: String,

    @Column(name = "created_at", insertable = false, updatable = false)
    var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at", insertable = false, updatable = false)
    var updatedAt: LocalDateTime? = null
) {
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    var children: MutableList<CommentEntity> = mutableListOf()

    internal fun toDto() = CommentDto(
        id = requireNotNull(id),
        reflectionId = requireNotNull(reflection.id),
        authorAccountId = requireNotNull(authorAccount.id),
        parentCommentId = parent?.id,
        body = body,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}
