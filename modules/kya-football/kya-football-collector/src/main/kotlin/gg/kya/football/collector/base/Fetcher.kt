package gg.kya.football.collector.base

interface Fetcher<Response> {
    suspend fun fetchAll(params: Map<String, Any?>): List<Response>
}