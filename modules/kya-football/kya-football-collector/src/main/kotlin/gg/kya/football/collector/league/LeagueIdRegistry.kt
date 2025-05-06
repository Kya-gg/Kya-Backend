package gg.kya.football.collector.league

import gg.kya.football.collector.base.BaseIdRegistry
import gg.kya.football.collector.base.BaseIdRegistryTable
import gg.kya.football.common.league.domain.Leagues
import org.springframework.stereotype.Component

@Component
class LeagueIdRegistry : BaseIdRegistry<Leagues>(LeagueIdRegistryTable)

object LeagueIdRegistryTable : BaseIdRegistryTable<Leagues>(
    name = "league_external_id_mapping",
    internalEntityTable = Leagues,
)