package gg.kya.support

import gg.kya.league.domain.Leagues
import gg.kya.player.domain.Players
import gg.kya.squad.domain.Squads
import gg.kya.statistic.player.domain.PlayerStatistics
import gg.kya.team.domain.Teams
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
        SchemaUtils.create(Squads)
    }
}