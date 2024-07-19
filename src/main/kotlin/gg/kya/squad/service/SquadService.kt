package gg.kya.squad.service

import gg.kya.squad.domain.SquadPlayer
import gg.kya.squad.domain.SquadPlayers
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SquadService {
    @Transactional
    fun getSquadPlayers(teamId: Long): List<SquadPlayer> {
        return SquadPlayer.find { SquadPlayers.teamId eq teamId }.toList()
    }
}