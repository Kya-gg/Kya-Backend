package gg.kya.football.collector.league

import gg.kya.football.collector.af.league.AfLeagueCollector
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
class LeagueCollectorController(
    private val afLeagueCollector: AfLeagueCollector,
) {
    @PostMapping("/fetch-leagues")
    suspend fun fetchLeagues(): ResponseEntity<String> {
        afLeagueCollector.collect()
        return ResponseEntity.ok("GOOD")
    }
}
