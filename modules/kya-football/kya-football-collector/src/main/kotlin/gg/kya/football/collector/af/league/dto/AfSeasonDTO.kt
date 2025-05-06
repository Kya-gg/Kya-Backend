package gg.kya.football.collector.af.league.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class AfSeasonDTO(
    val year: Long,
    val start: String,
    val end: String,
    val current: Boolean,
    val coverage: Coverage,
) {
    data class Coverage(
        val fixtures: Fixtures,

        val standings: Boolean,

        val players: Boolean,

        @JsonProperty("top_scorers")
        val topScorers: Boolean,

        @JsonProperty("top_assists")
        val topAssists: Boolean,

        @JsonProperty("top_cards")
        val topCards: Boolean,

        val injuries: Boolean,

        val predictions: Boolean,

        val odds: Boolean,
    ) {
        data class Fixtures(
            val events: Boolean,
            val lineups: Boolean,
            @JsonProperty("statistics_fixtures")
            val statisticsFixtures: Boolean,
            @JsonProperty("statistics_players")
            val statisticsPlayers: Boolean,
        )
    }
}