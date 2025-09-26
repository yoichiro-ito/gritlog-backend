package jpa.entity

import account.AccountDto
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "account")
class AccountEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "name_kanji_kana", nullable = false, length = 50)
    var nameKanjiKana: String,

    @Column(name = "name_kana", nullable = false, length = 50)
    var nameKana: String,

    @Column(name = "name_alphabet", length = 50)
    var nameAlphabet: String? = null,

    @Column(name = "login_id", nullable = false, length = 255)
    var loginId: String,

    @Column(name = "password", length = 255)
    var password: String? = null,

    @Column(name = "initial_password", length = 255)
    var initialPassword: String? = null,

    @Column(length = 255)
    var email: String? = null,

    @Column(name = "password_attempts", nullable = false)
    var passwordAttempts: Int = 0,

    @Column(name = "login_failure_at")
    var loginFailureAt: LocalDateTime? = null,

    @Column(name = "locked_at")
    var lockedAt: LocalDateTime? = null,

    @Column(name = "changed_password_at")
    var changedPasswordAt: LocalDateTime? = null,

    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime? = null,

    @Column(name = "created_by")
    var createdBy: Long? = null,

    @Column(name = "updated_by")
    var updatedBy: Long? = null,

    @Column(name = "created_at", insertable = false, updatable = false)
    var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at", insertable = false, updatable = false)
    var updatedAt: LocalDateTime? = null
) {

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    var goals: MutableList<GoalEntity> = mutableListOf()

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    var reflections: MutableList<ReflectionEntity> = mutableListOf()

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    var accountRoles: MutableSet<AccountRoleEntity> = mutableSetOf()

}
