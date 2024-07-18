package gg.kya.team.controller

import gg.kya.team.api.TeamApi
import gg.kya.team.controller.dto.response.TeamResponse
import org.springframework.stereotype.Controller

@Controller
class TeamController : TeamApi {
    // TODO: Implement this
    override fun getTeams(leagueId: Long?, count: Int?): List<TeamResponse> {
        // mock
        val finalCount = count ?: 10

        return (1..finalCount).map {
            TeamResponse(
                id = it.toLong(),
                leagueId = leagueId ?: 1,
                name = "Mocking Team $it",
                koreanName = "모킹 팀 $it",
                logoURL = null
            )
        }
    }

    override fun getLeagueById(teamId: Long): TeamResponse {
        return TeamResponse(
            id = teamId,
            leagueId = 1,
            name = "Mocking Team $teamId",
            koreanName = "모킹 팀 $teamId",
            logoURL = null
        )
    }
}