package gg.kya.football.collector.af.base

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class AfConfiguration {
    @Bean
    fun webClient(
        @Value("\${api.api-football.base-url}") baseUrl: String,
        @Value("\${api.api-football.host}") host: String,
        @Value("\${api.api-football.key}") apiKey: String,
    ): WebClient {
        return WebClient.builder()
            .baseUrl(baseUrl)
            .defaultHeaders {
                it.add("x-rapidapi-host", host)
                it.add("x-rapidapi-key", apiKey)
            }
            .build()
    }

    @Bean
    fun objectMapper(): ObjectMapper {
        return jacksonObjectMapper().apply {
            propertyNamingStrategy = PropertyNamingStrategy.LOWER_CAMEL_CASE
            setSerializationInclusion(Include.NON_NULL)
        }
    }
}