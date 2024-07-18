package gg.kya.player.controller

import gg.kya.player.api.PlayerApi
import gg.kya.player.controller.dto.response.PlayerResponse
import gg.kya.player.service.PlayerService
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