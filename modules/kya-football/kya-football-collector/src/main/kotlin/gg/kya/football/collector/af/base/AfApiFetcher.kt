package gg.kya.football.collector.af.base

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono


@Component
class AfApiFetcher(
    private val webClient: WebClient,
    private val mapper: ObjectMapper,
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    suspend fun <T> fetch(
        uri: String,
        typeReference: TypeReference<T>,
        queryParams: Map<String, Any?> = emptyMap(),
    ): T = withContext(Dispatchers.IO) {
        try {
            val responseMono: Mono<String> = webClient.get()
                .uri { builder ->
                    var b = builder.path(uri)
                    queryParams.forEach { (k, v) -> if (v != null) b = b.queryParam(k, v) }
                    b.build()
                }
                .retrieve()
                .onStatus({ !it.is2xxSuccessful }) { resp ->
                    resp.bodyToMono<String>().map { body ->
                        logger.error("API Error: $body")
                        RuntimeException("API returned error: $body")
                    }
                }
                .bodyToMono(String::class.java)

            val json = responseMono.block() ?: throw RuntimeException("API 응답 없음")
            mapper.readValue(json, typeReference)
        } catch (e: Exception) {
            logger.error("API fetch 실패: uri=$uri, params=$queryParams", e)
            throw e
        }
    }
}
