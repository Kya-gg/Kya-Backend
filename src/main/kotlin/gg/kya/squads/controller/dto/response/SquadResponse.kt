package gg.kya.squads.controller.dto.response

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "스쿼드 정보 응답")
data class SquadResponse(
    @Schema(description = "팀 ID", example = "1")
    val teamId: Long,
    @Schema(description = "스쿼드 선수 목록")
    val players: List<SquadPlayerResponse>
)