package gg.kya.football.common.team.service

import gg.kya.football.common.mapping.TeamLeagueMappingRegistry
import gg.kya.football.common.team.domain.Team
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TeamService(
    private val teamLeagueMappingRegistry: TeamLeagueMappingRegistry,
) {
    @Transactional
    fun getTeamsByLeagueIdAndSeason(leagueId: Long, season: Int): List<Team> {
        return teamLeagueMappingRegistry
            .findTeamIdsByLeague(leagueId, season)
            .map(Team.Companion::get)
            .toList()
    }

    @Transactional
    fun getTeamById(teamId: Long): Team? {
        return Team.findById(teamId)
    }
}