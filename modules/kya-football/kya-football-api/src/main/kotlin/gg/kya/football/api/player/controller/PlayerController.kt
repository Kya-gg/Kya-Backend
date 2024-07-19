package gg.kya.football.api.player.controller

import gg.kya.football.api.player.PlayerApi
import gg.kya.football.api.player.controller.dto.response.PlayerResponse
import gg.kya.football.common.player.service.PlayerService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.server.ResponseStatusException

@Controller
class PlayerController(
    private val playerService: PlayerService
) : PlayerApi {
    override fun getPlayer(playerId: Long): PlayerResponse {
        val player = playerService.findPlayerById(playerId)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found")

        return PlayerResponse.from(player)
    }
}