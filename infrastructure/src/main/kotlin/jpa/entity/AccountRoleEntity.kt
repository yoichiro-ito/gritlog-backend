package jpa.entity

import account.AccountRoleDto
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.Table
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
    var role: RoleEntity,
) {
    internal fun toDto() =
        AccountRoleDto(
            accountId = requireNotNull(id.accountId),
            roleId = requireNotNull(id.roleId),
        )
}

@Embeddable
data class AccountRoleId(
    @Column(name = "account_id")
    var accountId: Long? = null,
    @Column(name = "role_id")
    var roleId: Long? = null,
) : Serializable
