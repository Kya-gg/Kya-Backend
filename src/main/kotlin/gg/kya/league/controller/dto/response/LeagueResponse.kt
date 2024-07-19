package gg.kya.league.controller.dto.response

import gg.kya.league.domain.League
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "리그 정보 응답")
data class LeagueResponse(
    val id: Long,
    val name: String,
    val koreanName: String?,
    val logoURL: String?
) {
    companion object {
        fun from(league: League): LeagueResponse {
            return LeagueResponse(
                id = league.id.value,
                name = league.name,
                koreanName = league.koreanName,
                logoURL = league.logoURL
            )
        }
    }
}