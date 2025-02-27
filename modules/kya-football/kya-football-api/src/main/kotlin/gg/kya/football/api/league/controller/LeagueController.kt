package gg.kya.football.api.league.controller

import gg.kya.football.api.league.LeagueApi
import gg.kya.football.api.league.controller.dto.response.LeagueResponse
import gg.kya.football.common.league.service.LeagueService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.server.ResponseStatusException

@Controller
class LeagueController(
    private val leagueService: LeagueService
) : LeagueApi {
    override fun getLeagues(count: Int?): List<LeagueResponse> {
        return leagueService
            .findAll(count)
            .map(LeagueResponse::from)
    }

    override fun getLeagueById(leagueId: Long): LeagueResponse {
        val league = leagueService.findByLeagueId(leagueId)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "League not found")

        return LeagueResponse.from(league)
    }
}