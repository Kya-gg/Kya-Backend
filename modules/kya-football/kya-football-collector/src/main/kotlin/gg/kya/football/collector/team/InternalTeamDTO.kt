package gg.kya.football.collector.team

import gg.kya.football.collector.DataProvider
import gg.kya.football.collector.base.BaseInternalDTO

data class InternalTeamDTO(
    override val provider: DataProvider,
    override val externalId: Long,
    val id: Long?,
    val name: String?,
    val koreanName: String?,
    val logoURL: String?,
) : BaseInternalDTO()