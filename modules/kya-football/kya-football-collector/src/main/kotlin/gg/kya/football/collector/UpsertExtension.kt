package gg.kya.football.collector

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass

inline fun <T : LongEntity> LongEntityClass<T>.upsert(
    id: Long?,
    crossinline apply: T.() -> Unit,
): T {
    return if (id != null) {
        val entity = findById(id) ?: throw IllegalArgumentException("Entity with id $id not found")
        entity.apply(apply)
        entity
    } else {
        new { apply(this) }
    }
}