package gg.kya.squad.domain

import gg.kya.player.domain.Player
import gg.kya.player.domain.Players
import gg.kya.team.domain.Team
import gg.kya.team.domain.Teams
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable

class SquadPlayer(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<SquadPlayer>(SquadPlayers)

    var player by Player referencedOn SquadPlayers.playerId
    var team by Team referencedOn SquadPlayers.teamId
    var number by SquadPlayers.number
    var position by SquadPlayers.position
}

object SquadPlayers : LongIdTable("squad_player") {
    val playerId = reference("player_id", Players)
    val teamId = reference("team_id", Teams)
    val number = integer("number").nullable()
    val position = varchar("position", 25).nullable()

    @Suppress("unused")
    val teamPlayerUniqueKey = uniqueIndex(playerId, teamId)
}