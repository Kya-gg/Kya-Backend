package gg.kya.football.collector.base

abstract class BaseDataIdMapper {
    abstract fun registerExternalId(internalId: Long, externalId: Long)

    abstract fun getExternalId(internalId: Long): Long?

    abstract fun getInternalId(externalId: Long): Long?
}