package gg.kya.statistic.player.api

import gg.kya.statistic.player.controller.dto.response.PlayerStatisticResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "선수 통계", description = "선수 통계 API")
@RestController
@RequestMapping("/v1/players/{playerId}/statistics")
interface PlayerStatisticApi {
    @GetMapping
    fun getPlayerStatistics(
        @PathVariable playerId: Long,
        season: String?,
        leagueId: Long?,
        teamId: Long?
    ): List<PlayerStatisticResponse>
}