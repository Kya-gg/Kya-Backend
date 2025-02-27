package gg.kya.football.api.squad

import gg.kya.football.api.squad.controller.dto.response.SquadResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "스쿼드", description = "스쿼드 정보 API")
@RestController
@RequestMapping("/v1/squads")
interface SquadApi {
    @GetMapping("/{teamId}")
    fun getSquad(@PathVariable teamId: Long): SquadResponse
}