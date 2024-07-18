package gg.kya.statistic.player.controller

import gg.kya.statistic.player.api.PlayerStatisticApi
import gg.kya.statistic.player.controller.dto.response.PlayerStatisticResponse
import org.springframework.stereotype.Controller

@Controller
class PlayerStatisticController : PlayerStatisticApi {
    // TODO: Implement this
    override fun getPlayerStatistics(
        playerId: Long,
        season: String?,
        leagueId: Long?,
        teamId: Long?
    ): List<PlayerStatisticResponse> {
        // mock
        val mock = PlayerStatisticResponse(
            playerId = 1,
            leagueId = leagueId ?: 1,
            teamId = teamId ?: 1,
            season = season ?: "2024",
            shots = PlayerStatisticResponse.Shots(
                total = 10,
                onTarget = 5
            ),
            goals = PlayerStatisticResponse.Goals(
                total = 5,
                conceded = null,
                assists = 2,
                saves = null
            ),
            passes = PlayerStatisticResponse.Passes(
                total = 100,
                key = 10,
                accuracy = 36
            ),
            tackles = PlayerStatisticResponse.Tackles(
                total = 10,
                blocks = null,
                interceptions = 3
            ),
            duels = PlayerStatisticResponse.Duels(
                total = 20,
                won = 10
            ),
            fouls = PlayerStatisticResponse.Fouls(
                drawn = 5,
                committed = 3
            ),
            cards = PlayerStatisticResponse.Cards(
                yellow = 1,
                red = 0
            ),
            penalty = PlayerStatisticResponse.Penalty(
                scored = 2,
                missed = 1,
                won = null,
                committed = null,
                saved = null
            )
        )

        return listOf(mock)
    }
}