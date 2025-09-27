package app.gritlog.application

import app.gritlog.domain.team.valueobject.TeamCategory
import app.gritlog.domain.valueobject.Sex
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TeamCreateForm(
    @field:NotBlank @field:Size(max = 100)
    val teamName: String,
    @field:NotNull
    val sex: Sex,
    @field:NotNull
    val teamCategory: TeamCategory,
    @field:NotNull
    val representativeId: Long,
    @field:Min(0)
    val playersCount: Int? = null,
)

data class TeamSearchForm(
    val keyword: String? = null,
    val sex: Sex? = null,
    val teamCategory: TeamCategory? = null,
    val representativeId: Long? = null,
)

data class TeamEditForm(
    val teamName: String? = null,
    val sex: Sex? = null,
    val teamCategory: TeamCategory? = null,
    val representativeId: Long? = null,
    @field:Min(0)
    val playersCount: Int? = null,
    /** リクエスト側の更新世代（軽い排他）。使わない場合は null で可 */
    val ifMatchUpdatedAtEpochMillis: Long? = null,
)
