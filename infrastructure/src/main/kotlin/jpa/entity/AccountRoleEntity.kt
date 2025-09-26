package jpa.entity

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "account_role")
class AccountRoleEntity(

    @EmbeddedId
    var id: AccountRoleId = AccountRoleId(),

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("accountId")
    @JoinColumn(name = "account_id", nullable = false)
    var account: AccountEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roleId")
    @JoinColumn(name = "role_id", nullable = false)
    var role: RoleEntity
)

@Embeddable
data class AccountRoleId(
    @Column(name = "account_id")
    var accountId: Long? = null,
    @Column(name = "role_id")
    var roleId: Long? = null
) : Serializable
