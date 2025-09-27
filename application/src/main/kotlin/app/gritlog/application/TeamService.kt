package app.gritlog.application

import app.gritlog.application.common.OperationGuard
import app.gritlog.application.common.exception.ConflictException
import app.gritlog.application.common.exception.NotFoundException
import app.gritlog.application.common.exception.PreconditionFailedException
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

class TeamService(
    private val guard: OperationGuard,
    private val teamRepository: app.gritlog.application.ITeamRepository,
) {
    fun search(
        operatorAccountId: Long,
        form: app.gritlog.application.TeamSearchForm,
    ): List<app.gritlog.application.TeamDto> {
        guard.ensureAccountExists(operatorAccountId)
        return teamRepository.search(form)
    }

    fun get(
        operatorAccountId: Long,
        teamId: Long,
    ): app.gritlog.application.TeamDto {
        guard.ensureAccountExists(operatorAccountId)
        return teamRepository.findById(teamId) ?: throw NotFoundException("Team(id=$teamId) is not found.")
    }

    @Transactional
    fun create(
        operatorAccountId: Long,
        form: app.gritlog.application.TeamCreateForm,
    ): Long {
        guard.ensureAccountExists(operatorAccountId)

        if (teamRepository.existsByUniqueKey(form.teamName, form.teamCategory, form.sex, null)) {
            throw ConflictException("Team already exists: name=${form.teamName}, category=${form.teamCategory}, sex=${form.sex}")
        }

        val newDto =
            app.gritlog.application.TeamDto(
                id = 0L,
                teamName = form.teamName.trim(),
                sex = form.sex.toString(),
                teamCategory = form.teamCategory.toString(),
                representativeId = form.representativeId,
                playersCount = form.playersCount ?: 0,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now(),
            )
        return teamRepository.insert(newDto)
    }

    @Transactional
    fun update(
        operatorAccountId: Long,
        teamId: Long,
        form: app.gritlog.application.TeamEditForm,
    ) {
        guard.ensureAccountExists(operatorAccountId)

        val current = teamRepository.findById(teamId) ?: throw NotFoundException("Team(id=$teamId) is not found.")

// 軽い排他（If-Match 風）
        if (form.ifMatchUpdatedAtEpochMillis != null && current.updatedAtEpochMillis != null) {
            if (form.ifMatchUpdatedAtEpochMillis != current.updatedAtEpochMillis) {
                throw PreconditionFailedException("Team(id=$teamId) was modified by others.")
            }
        }

        val next =
            current.copy(
                teamName = form.teamName?.trim() ?: current.teamName,
                sex = form.sex.toString(),
                teamCategory = form.teamCategory.toString(),
                representativeId = form.representativeId ?: current.representativeId,
                playersCount = form.playersCount ?: current.playersCount,
            )

// 重複チェック（自身以外）
        if (teamRepository.existsByUniqueKey(next.teamName, next.teamCategory, next.sex, excludeId = teamId)) {
            throw ConflictException("Team already exists: name=${next.teamName}, category=${next.teamCategory}, sex=${next.sex}")
        }

        teamRepository.update(next)
    }

    @Transactional
    fun delete(
        operatorAccountId: Long,
        teamId: Long,
    ) {
        guard.ensureAccountExists(operatorAccountId)
// TODO: 関連エンティティの外部参照チェックを入れるならここに
        teamRepository.delete(teamId)
    }
}
