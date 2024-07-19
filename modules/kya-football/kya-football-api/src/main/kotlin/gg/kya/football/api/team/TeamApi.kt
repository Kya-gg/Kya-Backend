package gg.kya.football.api.team

import gg.kya.football.api.team.controller.dto.response.TeamResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "팀", description = "팀 정보 API")
@RestController
@RequestMapping("/v1/teams")
interface TeamApi {
    @Operation(summary = "팀 목록 조회", description = "팀 목록을 조회합니다.")
    @GetMapping("/")
    fun getTeams(leagueId: Long?, count: Int?): List<TeamResponse>

    @GetMapping("/{teamId}")
    @Operation(summary = "팀 단건 조회", description = "팀을 조회합니다.")
    fun getTeamById(@PathVariable teamId: Long): TeamResponse
}