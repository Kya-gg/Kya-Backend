package gg.kya.league.api

import gg.kya.league.controller.dto.response.LeagueResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "리그", description = "리그 정보 API")
@RestController
@RequestMapping("/v1/leagues")
interface LeagueApi {
    @Operation(summary = "리그 n건 조회", description = "리그 n건을 조회합니다.")
    @GetMapping("/")
    fun getLeagues(count: Int?): List<LeagueResponse>

    @GetMapping("/{leagueId}")
    @Operation(summary = "리그 단건 조회", description = "리그를 조회합니다.")
    fun getLeagueById(@PathVariable leagueId: Long): LeagueResponse
}