package gg.kya.statistic.player.controller.dto.response

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "선수 통계 응답")
data class PlayerStatisticResponse(
    @Schema(description = "선수 ID", example = "1") val playerId: Long,
    @Schema(description = "팀 ID", example = "1") val teamId: Long,
    @Schema(description = "리그 ID", example = "1") val leagueId: Long,
    @Schema(description = "시즌", example = "2024") val season: String,
    val shots: Shots,
    val goals: Goals,
    val passes: Passes,
    val tackles: Tackles,
    val duels: Duels,
    val fouls: Fouls,
    val cards: Cards,
    val penalty: Penalty
) {
    @Schema(description = "슛 통계")
    data class Shots(
        @Schema(description = "총 슛 수") val total: Int?,
        @Schema(description = "유효 슛 수") val onTarget: Int?
    )

    @Schema(description = "골 통계")
    data class Goals(
        @Schema(description = "총 득점 수") val total: Int?,
        @Schema(description = "실점 수") val conceded: Int?,
        @Schema(description = "어시스트 수") val assists: Int?,
        @Schema(description = "세이브 수") val saves: Int?
    )

    @Schema(description = "패스 통계")
    data class Passes(
        @Schema(description = "총 패스 수") val total: Int?,
        @Schema(description = "키 패스 수") val key: Int?,
        @Schema(description = "패스 정확도 (%)") val accuracy: Int?
    )

    @Schema(description = "태클 통계")
    data class Tackles(
        @Schema(description = "총 태클 수") val total: Int?,
        @Schema(description = "블록 수") val blocks: Int?,
        @Schema(description = "인터셉트 수") val interceptions: Int?
    )

    @Schema(description = "듀얼 통계")
    data class Duels(
        @Schema(description = "총 듀얼 수") val total: Int?,
        @Schema(description = "승리한 듀얼 수") val won: Int?
    )

    @Schema(description = "파울 통계")
    data class Fouls(
        @Schema(description = "얻은 파울 수") val drawn: Int?,
        @Schema(description = "범한 파울 수") val committed: Int?
    )

    @Schema(description = "카드 통계")
    data class Cards(
        @Schema(description = "옐로우 카드 수") val yellow: Int?,
        @Schema(description = "레드 카드 수") val red: Int?
    )

    @Schema(description = "페널티 통계")
    data class Penalty(
        @Schema(description = "얻은 페널티 수") val won: Int?,
        @Schema(description = "범한 페널티 수") val committed: Int?,
        @Schema(description = "성공한 페널티 수") val scored: Int?,
        @Schema(description = "실패한 페널티 수") val missed: Int?,
        @Schema(description = "세이브한 페널티 수") val saved: Int?,
    )
}
