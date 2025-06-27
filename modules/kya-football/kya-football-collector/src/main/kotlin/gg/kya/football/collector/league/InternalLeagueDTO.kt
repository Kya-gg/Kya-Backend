package gg.kya.football.collector.league

import gg.kya.football.collector.DataProvider
import gg.kya.football.collector.base.BaseInternalDTO

data class InternalLeagueDTO(
    override val provider: DataProvider,
    override val externalId: Long,
    val id: Long?,
    val name: String?,
    val koreanName: String?,
    val logoURL: String?,
) : BaseInternalDTO()