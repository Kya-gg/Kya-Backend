package gg.kya.player.domain

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

class Player(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<Player>(Players)

    var name by Players.name
    var firstName by Players.firstName
    var lastName by Players.lastName
    var koreanName by Players.koreanName
    var age by Players.age
    var birthDate by Players.birthDate
    var height by Players.height
    var weight by Players.weight
    var photoURL by Players.photoURL
}

object Players : LongIdTable("players") {
    val name = varchar("name", 50)
    val firstName = varchar("first_name", 50)
    val lastName = varchar("last_name", 50)
    val koreanName = varchar("korean_name", 50).nullable()
    val age = uinteger("age").nullable()
    val birthDate = datetime("birth_date").nullable()
    val height = uinteger("height").nullable()
    val weight = uinteger("weight").nullable()
    val photoURL = varchar("photo_url", 255).nullable()
}


