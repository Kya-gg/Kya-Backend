package gg.kya.football.collector.af.base

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class AfWelcomeDTO<Response>(
    val get: String,
    val errors: List<AfErrorsDTO>,
    val results: Long,
    val paging: Paging,
    val response: List<Response>,
) {
    data class Paging(
        val current: Long,
        val total: Long,
    )

    data class AfErrorsDTO(
        val time: String?,
        val bug: String?,
        val report: String?,
    )
}

