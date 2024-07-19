package gg.kya.football.common.support

import gg.kya.football.common.league.domain.Leagues
import gg.kya.football.common.player.domain.Players
import gg.kya.football.common.squad.domain.SquadPlayers
import gg.kya.football.common.statistic.player.domain.PlayerStatistics
import gg.kya.football.common.team.domain.Teams
import org.jetbrains.exposed.sql.SchemaUtils
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class SchemaInitialize : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        SchemaUtils.create(Players)
        SchemaUtils.create(PlayerStatistics)
        SchemaUtils.create(Leagues)
        SchemaUtils.create(Teams)
        SchemaUtils.create(SquadPlayers)
    }
}