package gg.kya.football.collector.af.league

import gg.kya.football.collector.DataProvider
import gg.kya.football.collector.league.BaseLeagueCollector
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service

@Service
class AfLeagueCollector(
    private val afLeagueConverter: AfLeagueConverter,
    private val afLeagueFetcher: AfLeagueFetcher,
) : BaseLeagueCollector() {
    suspend fun collect() {
        val leagues = afLeagueFetcher.fetchAll(mapOf("code" to "it")).map { it.league } // TODO
        val internalLeagues = afLeagueConverter.convertBatch(leagues, DataProvider.API_FOOTBALL)

        transaction {
            saveAll(internalLeagues)
        }
    }
}