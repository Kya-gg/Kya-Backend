package gg.kya.football.collector.af.base

import com.fasterxml.jackson.core.type.TypeReference
import gg.kya.football.collector.base.Fetcher

abstract class AfBaseFetcher<T>(
    private val uri: String,
    private val afApiFetcher: AfApiFetcher,
    private val typeReference: TypeReference<AfWelcomeDTO<T>>,
) : Fetcher<T> {
    override suspend fun fetchAll(params: Map<String, Any?>): List<T> {
        val dto: AfWelcomeDTO<T> = afApiFetcher.fetch(
            uri = uri,
            typeReference = typeReference,
            queryParams = params,
        )

        return dto.response
    }
}
