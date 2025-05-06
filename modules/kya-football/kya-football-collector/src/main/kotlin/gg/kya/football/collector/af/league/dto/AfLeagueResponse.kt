package gg.kya.football.collector.af.league.dto

data class AfLeagueResponse(
    val league: AfLeagueDTO,
    val country: AfCountryDTO,
    val seasons: List<AfSeasonDTO>,
)