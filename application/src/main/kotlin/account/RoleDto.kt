package account

import java.time.LocalDateTime

data class RoleDto(
    val id: Long,
    val name: String,
    val code: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
)
