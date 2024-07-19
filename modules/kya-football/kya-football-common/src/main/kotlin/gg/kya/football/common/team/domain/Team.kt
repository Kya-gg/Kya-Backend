package gg.kya.football.common.team.domain

import gg.kya.football.common.league.domain.League
import gg.kya.football.common.league.domain.Leagues
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable

class Team(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<Team>(Teams)

    var name by Teams.name
    var league by League referencedOn Teams.leagueId
    var koreanName by Teams.koreanName
    var logoURL by Teams.logoURL
}

object Teams : LongIdTable("team") {
    val name = varchar("name", 50)
    val leagueId = reference("league_id", Leagues)
    val koreanName = varchar("korean_name", 50).nullable()
    val logoURL = text("logo_url").nullable()
}