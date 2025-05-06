package gg.kya.football.common.mapping

import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class TeamLeagueMappingRegistry {
    @Transactional
    fun register(teamId: Long, leagueId: Long, season: Int): Long {
        return transaction {
            val existing = TeamLeagueMapping
                .selectAll()
                .where { (TeamLeagueMapping.team eq teamId) and (TeamLeagueMapping.league eq leagueId) and (TeamLeagueMapping.season eq season) }
                .map { it[TeamLeagueMapping.id].value }
                .singleOrNull()
            existing ?: TeamLeagueMapping.insertAndGetId {
                it[this.team] = teamId
                it[this.league] = leagueId
                it[this.season] = season
            }.value
        }
    }

    @Transactional(readOnly = true)
    fun findLeagueIdsByTeam(teamId: Long, season: Int): List<Long> {
        return transaction {
            TeamLeagueMapping
                .selectAll()
                .where { (TeamLeagueMapping.team eq teamId) and (TeamLeagueMapping.season eq season) }
                .map { it[TeamLeagueMapping.league].value }
        }
    }

    @Transactional(readOnly = true)
    fun findTeamIdsByLeague(leagueId: Long, season: Int): List<Long> {
        return transaction {
            TeamLeagueMapping
                .selectAll()
                .where { (TeamLeagueMapping.team eq leagueId) and (TeamLeagueMapping.season eq season) }
                .map { it[TeamLeagueMapping.team].value }
        }
    }
}
