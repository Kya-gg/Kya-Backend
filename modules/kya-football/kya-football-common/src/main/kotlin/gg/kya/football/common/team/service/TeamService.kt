package gg.kya.football.common.team.service

import gg.kya.football.common.team.domain.Team
import gg.kya.football.common.team.domain.Teams
import org.jetbrains.exposed.sql.SizedIterable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TeamService {
    @Transactional
    fun getTeamsByLeagueId(leagueId: Long?, count: Int?): List<Team> {
        if (leagueId == null) {
            return Team.all().limit(count).toList()
        }

        return Team
            .find { Teams.leagueId eq leagueId }
            .limit(count)
            .toList()
    }

    @Transactional
    fun getTeamById(teamId: Long): Team? {
        return Team.findById(teamId)
    }

    private fun <T> SizedIterable<T>.limit(count: Int?): SizedIterable<T> {
        return if (count != null) {
            this.limit(count)
        } else {
            this
        }
    }
}