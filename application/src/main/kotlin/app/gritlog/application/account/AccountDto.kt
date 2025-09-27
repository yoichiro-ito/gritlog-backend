package app.gritlog.application.account

import java.time.LocalDateTime

data class AccountDto(
    val id: Long,
    val nameKanjiKana: String,
    val nameKana: String,
    val nameAlphabet: String?,
    val loginId: String,
    val email: String?,
    val passwordAttempts: Int,
    val loginFailureAt: LocalDateTime?,
    val lockedAt: LocalDateTime?,
    val changedPasswordAt: LocalDateTime?,
    val deletedAt: LocalDateTime?,
    val createdBy: Long?,
    val updatedBy: Long?,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
)
