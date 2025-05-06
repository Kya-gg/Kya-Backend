package gg.kya.football.collector.af.league

import com.fasterxml.jackson.core.type.TypeReference
import gg.kya.football.collector.af.base.AfApiFetcher
import gg.kya.football.collector.af.base.AfBaseFetcher
import gg.kya.football.collector.af.base.AfWelcomeDTO
import gg.kya.football.collector.af.league.dto.AfLeagueResponse
import org.springframework.stereotype.Component

@Component
class AfLeagueFetcher(
    afApiFetcher: AfApiFetcher,
) : AfBaseFetcher<AfLeagueResponse>(
    uri = "/leagues",
    afApiFetcher = afApiFetcher,
    typeReference = object : TypeReference<AfWelcomeDTO<AfLeagueResponse>>() {},
)
