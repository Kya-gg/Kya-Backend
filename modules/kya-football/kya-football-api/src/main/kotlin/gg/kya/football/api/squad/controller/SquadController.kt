package gg.kya.football.api.squad.controller

import gg.kya.football.api.squad.SquadApi
import gg.kya.football.api.squad.controller.dto.response.SquadPlayerResponse
import gg.kya.football.api.squad.controller.dto.response.SquadResponse
import gg.kya.football.common.squad.service.SquadService
import org.springframework.stereotype.Controller

@Controller
class SquadController(
    private val squadService: SquadService
) : SquadApi {
    override fun getSquad(teamId: Long): SquadResponse {
        squadService.getSquadPlayers(teamId).let { squadPlayers ->
            return SquadResponse(
                teamId = teamId,
                players = squadPlayers.map { SquadPlayerResponse.from(it) }
            )
        }
    }
}