package gg.kya.squad.controller

import gg.kya.squad.api.SquadApi
import gg.kya.squad.controller.dto.response.SquadPlayerResponse
import gg.kya.squad.controller.dto.response.SquadResponse
import org.springframework.stereotype.Controller

@Controller
class SquadController : SquadApi {
    // TODO: Implement this
    override fun getTeamSquad(teamId: Long): SquadResponse {
        val players = mutableListOf<SquadPlayerResponse>()

        for (i in 1..11) {
            players.add(
                SquadPlayerResponse(
                    playerId = i.toLong(),
                    number = i,
                    position = "Attacker"
                )
            )
        }

        return SquadResponse(
            teamId = teamId,
            players = players
        )
    }
}