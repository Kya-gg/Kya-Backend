package gg.kya.player.dto.response

import gg.kya.player.domain.Player

data class PlayerResponse(
    val id: Long,
    val name: String,
    val firstName: String,
    val lastName: String,
    val koreanName: String?,
    val age: UInt?,
    val birthDate: String?,
    val height: UInt?,
    val weight: UInt?,
    val photoURL: String?
) {
    companion object {
        fun of(player: Player): PlayerResponse {
            return PlayerResponse(
                id = player.id.value,
                name = player.name,
                firstName = player.firstName,
                lastName = player.lastName,
                koreanName = player.koreanName,
                age = player.age,
                birthDate = player.birthDate?.toString(),
                height = player.height,
                weight = player.weight,
                photoURL = player.photoURL
            )
        }
    }
}