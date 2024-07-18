package gg.kya.team.controller

import gg.kya.team.api.TeamApi
import gg.kya.team.controller.dto.response.TeamResponse
import gg.kya.team.service.TeamService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.server.ResponseStatusException

@Controller
class TeamController(
    private val teamService: TeamService
) : TeamApi {
    override fun getTeams(leagueId: Long?, count: Int?): List<TeamResponse> {
        return teamService
            .getTeamsByLeagueId(leagueId, count)
            .map(TeamResponse::from)
    }

    override fun getTeamById(teamId: Long): TeamResponse {
        val team = teamService.getTeamById(teamId)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found")

        return TeamResponse.from(team)
    }
}