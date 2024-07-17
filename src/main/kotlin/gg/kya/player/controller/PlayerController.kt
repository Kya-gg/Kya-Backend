package gg.kya.player.controller

import gg.kya.player.dto.response.PlayerResponse
import gg.kya.player.service.PlayerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/v1/players")
class PlayerController(
    private val playerService: PlayerService
) {
    @GetMapping("/{playerId}")
    fun getPlayer(@PathVariable playerId: Long): PlayerResponse {
        val player = playerService.findPlayerById(playerId)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found")

        return PlayerResponse.of(player)
    }
}