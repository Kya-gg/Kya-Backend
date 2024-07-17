package gg.kya.player.service

import gg.kya.player.domain.Player
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PlayerService {
    fun findPlayerById(id: Long): Player? {
        return Player.findById(id)
    }
}