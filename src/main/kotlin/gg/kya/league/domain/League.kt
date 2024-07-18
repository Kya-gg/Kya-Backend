package gg.kya.league.domain

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable

class League(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<League>(Leagues)

    var name by Leagues.name
    var koreanName by Leagues.koreanName
    var logoURL by Leagues.logoURL
}

object Leagues : LongIdTable("league") {
    val name = varchar("name", 50)
    val koreanName = varchar("region", 50).nullable()
    val logoURL = text("logo_url").nullable()
}