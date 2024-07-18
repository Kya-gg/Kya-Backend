package gg.kya.squad.domain

import gg.kya.player.domain.Players
import gg.kya.team.domain.Teams
import org.jetbrains.exposed.sql.Table

object Squads : Table("squad") {
    val playerId = reference("player_id", Players)
    val teamId = reference("team_id", Teams)
    val number = integer("number").nullable()
    val position = varchar("position", 25).nullable()
    override val primaryKey = PrimaryKey(playerId, teamId)
}