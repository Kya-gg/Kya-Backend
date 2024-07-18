package gg.kya.statistic.player.domain

import gg.kya.league.domain.League
import gg.kya.league.domain.Leagues
import gg.kya.player.domain.Player
import gg.kya.player.domain.Players
import gg.kya.team.domain.Team
import gg.kya.team.domain.Teams
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable

class PlayerStatistic(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<PlayerStatistic>(PlayerStatistics)

    var player by Player referencedOn PlayerStatistics.player
    var team by Team referencedOn PlayerStatistics.team
    var league by League referencedOn PlayerStatistics.league

    var season by PlayerStatistics.season

    // SHOTS
    var shotsTotal by PlayerStatistics.shotsTotal
    var shotsOnTarget by PlayerStatistics.shotsOnTarget

    // GOALS
    var goalsTotal by PlayerStatistics.goalsTotal
    var goalsConceded by PlayerStatistics.goalsConceded
    var goalsAssists by PlayerStatistics.goalsAssists
    var goalsSaves by PlayerStatistics.goalsSaves

    // PASSES
    var passesTotal by PlayerStatistics.passesTotal
    var passesKey by PlayerStatistics.passesKey
    var passesAccuracy by PlayerStatistics.passesAccuracy

    // TACKLES
    var tacklesTotal by PlayerStatistics.tacklesTotal
    var tacklesBlocks by PlayerStatistics.tacklesBlocks
    var tacklesInterceptions by PlayerStatistics.tacklesInterceptions

    // DUELS
    var duelsTotal by PlayerStatistics.duelsTotal
    var duelsWon by PlayerStatistics.duelsWon

    // FOULS
    var foulsDrawn by PlayerStatistics.foulsDrawn
    var foulsCommitted by PlayerStatistics.foulsCommitted

    // CARDS
    var cardsYellow by PlayerStatistics.cardsYellow
    var cardsRed by PlayerStatistics.cardsRed

    // PENALTY
    var penaltyWon by PlayerStatistics.penaltyWon
    var penaltyCommited by PlayerStatistics.penaltyCommited
    var penaltyScored by PlayerStatistics.penaltyScored
    var penaltyMissed by PlayerStatistics.penaltyMissed

}

object PlayerStatistics : LongIdTable("player_statistic") {
    val player = reference("player_id", Players)
    val team = reference("team_id", Teams)
    val league = reference("league_id", Leagues)
    val season = varchar("season", 4)

    // SHOTS
    val shotsTotal = integer("shots_total").nullable()
    val shotsOnTarget = integer("shots_on_target").nullable()

    // GOALS
    val goalsTotal = integer("goals_total").nullable()
    val goalsConceded = integer("goals_conceded").nullable()
    val goalsAssists = integer("goals_assists").nullable()
    val goalsSaves = integer("goals_saves").nullable()

    // PASSES
    val passesTotal = integer("passes_total").nullable()
    val passesKey = integer("passes_key").nullable()
    val passesAccuracy = integer("passes_accuracy").nullable()

    // TACKLES
    val tacklesTotal = integer("tackles_total").nullable()
    val tacklesBlocks = integer("tackles_blocks").nullable()
    val tacklesInterceptions = integer("tackles_interceptions").nullable()

    // DUELS
    val duelsTotal = integer("duels_total").nullable()
    val duelsWon = integer("duels_won").nullable()

    // FOULS
    val foulsDrawn = integer("fouls_drawn").nullable()
    val foulsCommitted = integer("fouls_committed").nullable()

    // CARDS
    val cardsYellow = integer("cards_yellow").nullable()
    val cardsRed = integer("cards_red").nullable()

    // PENALTY
    val penaltyWon = integer("penalty_won").nullable()
    val penaltyCommited = integer("penalty_commited").nullable()
    val penaltyScored = integer("penalty_scored").nullable()
    val penaltyMissed = integer("penalty_missed").nullable()
}