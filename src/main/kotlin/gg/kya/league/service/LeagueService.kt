package gg.kya.league.service

import gg.kya.league.domain.League
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LeagueService {
    @Transactional
    fun findAll(count: Int?): List<League> {
        // TODO: Do I need to use pagination instead of count?
        return League
            .all()
            .limit(count ?: Int.MAX_VALUE)
            .toList()
    }

    @Transactional
    fun findByLeagueId(leagueId: Long): League? {
        return League.findById(leagueId)
    }
}