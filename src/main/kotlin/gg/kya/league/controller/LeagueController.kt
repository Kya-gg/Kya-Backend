package gg.kya.league.controller

import gg.kya.league.api.LeagueApi
import gg.kya.league.controller.dto.response.LeagueResponse
import org.springframework.stereotype.Controller

@Controller
class LeagueController : LeagueApi {
    // TODO: Implement this
    override fun getLeagues(count: Int?): List<LeagueResponse> {
        val finalCount = count ?: 10
        val leagues = mutableListOf<LeagueResponse>()

        for (i in 1..finalCount) {
            leagues.add(LeagueResponse(i.toLong(), "Mocking League $i", null))
        }

        return leagues
    }

    // TODO: Implement this
    override fun getLeagueById(leagueId: Long): LeagueResponse {
        return LeagueResponse(leagueId, "Mocking League $leagueId", null)
    }
}