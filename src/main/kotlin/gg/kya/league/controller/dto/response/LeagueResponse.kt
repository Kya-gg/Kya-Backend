package gg.kya.league.controller.dto.response

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "리그 정보 응답")
data class LeagueResponse(
    val id: Long,
    val name: String,
    val logoURL: String?
)