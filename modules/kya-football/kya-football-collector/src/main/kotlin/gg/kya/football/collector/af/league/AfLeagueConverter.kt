package gg.kya.football.collector.af.league

import gg.kya.football.collector.DataProvider
import gg.kya.football.collector.af.league.dto.AfLeagueDTO
import gg.kya.football.collector.base.Converter
import gg.kya.football.collector.league.LeagueIdRegistry
import gg.kya.football.common.league.InternalLeagueDTO
import org.springframework.stereotype.Component

@Component
class AfLeagueConverter(
    private val leagueIdRegistry: LeagueIdRegistry,
) : Converter<InternalLeagueDTO, AfLeagueDTO> {
    override fun convert(externalDTO: AfLeagueDTO, dataProvider: DataProvider): InternalLeagueDTO {
        return InternalLeagueDTO(
            id = leagueIdRegistry.findInternalId(externalDTO.id, dataProvider),
            name = externalDTO.name,
            logoURL = externalDTO.logo,
            koreanName = null
        )
    }
}