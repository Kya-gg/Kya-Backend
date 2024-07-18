package gg.kya.squads.controller.dto.response

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "스쿼드 선수 정보 응답")
data class SquadPlayerResponse(
    @Schema(description = "선수 ID", example = "1")
    val playerId: Long,
    @Schema(description = "선수 등 번호", example = "7")
    val number: Int?,
    @Schema(description = "선수 포지션", example = "Attacker")
    val position: String?
)