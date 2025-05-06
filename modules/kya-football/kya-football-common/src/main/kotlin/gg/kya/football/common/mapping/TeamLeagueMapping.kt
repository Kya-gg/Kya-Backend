package gg.kya.football.common.mapping

import gg.kya.football.common.league.domain.Leagues
import gg.kya.football.common.team.domain.Teams
import org.jetbrains.exposed.dao.id.LongIdTable

object TeamLeagueMapping : LongIdTable("team_league_mapping") {
    val team = reference("team_id", Teams)
    val league = reference("league_id", Leagues)
    val season = integer("season")

    init {
        uniqueIndex(team, league, season)
    }
}
