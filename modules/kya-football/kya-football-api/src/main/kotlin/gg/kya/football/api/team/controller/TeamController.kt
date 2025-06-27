package gg.kya.football.api.team.controller

import gg.kya.football.api.team.TeamApi
import gg.kya.football.api.team.controller.dto.response.TeamResponse
import gg.kya.football.common.team.domain.Team
import gg.kya.football.common.team.service.TeamService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.server.ResponseStatusException

@Controller
class TeamController(
    private val teamService: TeamService,
) : TeamApi {
    override fun getTeamsByLeagueIdAndSeason(leagueId: Long, season: Int): List<TeamResponse> {
        return teamService
            .getTeamsByLeagueIdAndSeason(leagueId, season)
            .map(this::toResponse)
    }

    override fun getTeamById(teamId: Long): TeamResponse {
        val team = teamService.getTeamById(teamId)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found")

        return toResponse(team)
    }

    private fun toResponse(team: Team): TeamResponse {
        return TeamResponse(
            id = team.id.value,
            name = team.name,
            koreanName = team.koreanName,
            logoURL = team.logoURL
        )
    }
}