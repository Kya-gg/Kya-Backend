package gg.kya.team.controller.dto.response

import gg.kya.team.domain.Team
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "팀 정보 응답")
data class TeamResponse(
    @Schema(description = "팀 ID", example = "1")
    val id: Long,
    @Schema(description = "리그 ID", example = "1")
    val leagueId: Long,
    @Schema(description = "팀 이름", example = "Manchester United")
    val name: String,
    @Schema(description = "팀 이름(한글)", example = "맨체스터 유나이티드")
    val koreanName: String?,
    @Schema(description = "팀 로고 URL")
    val logoURL: String?
) {
    companion object {
        fun from(team: Team): TeamResponse {
            return TeamResponse(
                id = team.id.value,
                leagueId = team.league.id.value,
                name = team.name,
                koreanName = team.koreanName,
                logoURL = team.logoURL
            )
        }
    }
}