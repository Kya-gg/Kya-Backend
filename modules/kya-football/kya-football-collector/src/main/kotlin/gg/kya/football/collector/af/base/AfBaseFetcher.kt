package gg.kya.football.collector.af.base

import com.fasterxml.jackson.core.type.TypeReference

abstract class AfBaseFetcher<T>(
    private val uri: String,
    private val afApiFetcher: AfApiFetcher,
    private val typeReference: TypeReference<AfWelcomeDTO<T>>,
) {
    suspend fun fetchAll(params: Map<String, Any?>): List<T> {
        val dto: AfWelcomeDTO<T> = afApiFetcher.fetch(
            uri = uri,
            typeReference = typeReference,
            queryParams = params,
        )

        return dto.response
    }
}
