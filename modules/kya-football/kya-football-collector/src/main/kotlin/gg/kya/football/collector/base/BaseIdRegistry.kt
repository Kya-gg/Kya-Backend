package gg.kya.football.collector.base

import gg.kya.football.collector.DataProvider
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.*
import org.springframework.transaction.annotation.Transactional

abstract class BaseIdRegistry<InternalEntityTable : LongIdTable>(
    private val table: BaseIdRegistryTable<InternalEntityTable>,
) {
    @Transactional(readOnly = true)
    open fun findExternalId(id: Long, dataProvider: DataProvider): Long? {
        return findByCondition(
            condition = { (table.internalId eq id) and (table.provider eq dataProvider) },
            get = { it[table.externalId] }
        )
    }

    @Transactional(readOnly = true)
    open fun findInternalId(externalId: Long, dataProvider: DataProvider): Long? {
        return findByCondition(
            condition = { (table.externalId eq externalId) and (table.provider eq dataProvider) },
            get = { it[table.internalId].value }
        )
    }

    @Transactional
    open fun register(internalId: Long, externalId: Long, dataProvider: DataProvider): Long {
        val existingId = findByCondition(
            condition = { (table.externalId eq externalId) and (table.provider eq dataProvider) },
            get = { it[table.id].value }
        )

        return existingId ?: table.insertAndGetId {
            it[table.internalId] = internalId
            it[table.provider] = dataProvider
            it[table.externalId] = externalId
        }.value
    }

    private fun findByCondition(
        condition: SqlExpressionBuilder.() -> Op<Boolean>,
        get: (ResultRow) -> Long?,
    ): Long? {
        return table.selectAll()
            .where(condition)
            .map(get)
            .singleOrNull()
    }
}

abstract class BaseIdRegistryTable<InternalEntityTable : LongIdTable>(
    name: String,
    internalEntityTable: InternalEntityTable,
) : LongIdTable(name) {
    val externalId = long("external_id").index()
    val internalId = reference("internal_id", internalEntityTable)
    val provider = enumeration<DataProvider>("provider")

    init {
        uniqueIndex(provider, externalId)
        uniqueIndex(internalId, provider)
    }
}