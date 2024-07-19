package gg.kya.squad.controller.dto.response

import gg.kya.squad.domain.SquadPlayer
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "스쿼드 선수 정보 응답")
data class SquadPlayerResponse(
    @Schema(description = "선수 ID", example = "1")
    val playerId: Long,
    @Schema(description = "선수 등 번호", example = "7")
    val number: Int?,
    @Schema(description = "선수 포지션", example = "Attacker")
    val position: String?
) {
    companion object {
        fun from(squadPlayer: SquadPlayer): SquadPlayerResponse {
            return SquadPlayerResponse(
                playerId = squadPlayer.player.id.value,
                number = squadPlayer.number,
                position = squadPlayer.position
            )
        }
    }
}