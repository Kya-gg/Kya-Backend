package gg.kya.statistic.player.service

import gg.kya.statistic.player.domain.PlayerStatistic
import gg.kya.statistic.player.domain.PlayerStatistics
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PlayerStatisticService {
    @Transactional
    fun getPlayerStatistics(
        playerId: Long,
        season: String?,
        leagueId: Long?,
        teamId: Long?
    ): List<PlayerStatistic> {
        var query = PlayerStatistics.player eq playerId

        season?.let {
            query = query and (PlayerStatistics.season eq it)
        }

        leagueId?.let {
            query = query and (PlayerStatistics.league eq it)
        }

        teamId?.let {
            query = query and (PlayerStatistics.team eq it)
        }

        return PlayerStatistic.find(query).toList()
    }
}