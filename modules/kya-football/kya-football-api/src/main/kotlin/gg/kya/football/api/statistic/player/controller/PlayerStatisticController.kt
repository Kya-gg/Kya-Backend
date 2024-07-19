package gg.kya.football.api.statistic.player.controller

import gg.kya.football.api.statistic.player.PlayerStatisticApi
import gg.kya.football.api.statistic.player.controller.dto.response.PlayerStatisticResponse
import gg.kya.football.common.statistic.player.service.PlayerStatisticService
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