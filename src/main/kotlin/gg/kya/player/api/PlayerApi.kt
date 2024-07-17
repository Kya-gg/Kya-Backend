package gg.kya.player.api

import gg.kya.player.dto.response.PlayerResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "선수", description = "선수 정보 API")
@RestController
@RequestMapping("/v1/players")
interface PlayerApi {
    @Operation(summary = "선수 정보 조회", description = "선수 정보를 조회합니다.")
    @GetMapping("/{playerId}")
    fun getPlayer(@PathVariable playerId: Long): PlayerResponse
}