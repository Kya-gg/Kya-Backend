package gg.kya.football.collector.league

import gg.kya.football.collector.base.Collector
import gg.kya.football.collector.upsert
import gg.kya.football.common.league.InternalLeagueDTO
import gg.kya.football.common.league.domain.League

abstract class BaseLeagueCollector : Collector<InternalLeagueDTO>() {
    override fun saveAll(leagues: List<InternalLeagueDTO>) {
        leagues.forEach { league ->
            League.upsert(league.id) {
                league.name?.let { this.name = it }

                league.logoURL?.let { this.logoURL = it }

                league.koreanName?.let { this.koreanName = it }
            }
        }
    }
}