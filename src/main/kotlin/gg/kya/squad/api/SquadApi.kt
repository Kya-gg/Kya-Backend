package gg.kya.squad.api

import gg.kya.squad.controller.dto.response.SquadResponse
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
    fun getTeamSquad(@PathVariable teamId: Long): SquadResponse
}