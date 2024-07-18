package gg.kya.squads.domain

import gg.kya.player.domain.Players
import gg.kya.team.domain.Teams
import org.jetbrains.exposed.sql.Table

object Squads : Table("squad") {
    val player = reference("player_id", Players)
    val team = reference("team_id", Teams)
    val number = integer("number").nullable()
    val position = varchar("position", 25).nullable()
    override val primaryKey = PrimaryKey(player, team)
}