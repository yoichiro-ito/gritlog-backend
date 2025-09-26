package jpa.entity

import account.RoleDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "role")
class RoleEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(nullable = false, length = 100)
    var name: String,
    @Column(nullable = false, length = 50)
    var code: String,
    @Column(name = "created_at", insertable = false, updatable = false)
    var createdAt: LocalDateTime? = null,
    @Column(name = "updated_at", insertable = false, updatable = false)
    var updatedAt: LocalDateTime? = null,
) {
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    var accountRoles: MutableSet<AccountRoleEntity> = mutableSetOf()

    internal fun toDto() =
        RoleDto(
            id = requireNotNull(id),
            name = name,
            code = code,
            createdAt = createdAt,
            updatedAt = updatedAt,
        )
}
