package gg.kya.football.collector.base

import gg.kya.football.collector.DataProvider

abstract class BaseInternalDTO {
    abstract val provider: DataProvider
    abstract val externalId: Long
}