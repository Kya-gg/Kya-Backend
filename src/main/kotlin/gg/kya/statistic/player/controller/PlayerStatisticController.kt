package gg.kya.statistic.player.controller

import gg.kya.statistic.player.api.PlayerStatisticApi
import gg.kya.statistic.player.controller.dto.response.PlayerStatisticResponse
import gg.kya.statistic.player.service.PlayerStatisticService
import org.springframework.stereotype.Controller

@Controller
class PlayerStatisticController(
    private val playerStatisticService: PlayerStatisticService
) : PlayerStatisticApi {
    override fun getPlayerStatistics(
        playerId: Long,
        season: String?,
        leagueId: Long?,
        teamId: Long?
    ): List<PlayerStatisticResponse> {
        return playerStatisticService
            .getPlayerStatistics(playerId, season, leagueId, teamId)
            .map(PlayerStatisticResponse::from)
    }
}