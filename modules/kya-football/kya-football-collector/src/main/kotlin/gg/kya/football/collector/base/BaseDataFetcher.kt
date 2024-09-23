package gg.kya.football.collector.base

abstract class BaseDataFetcher<ExternalDTO> {
    abstract fun fetch(): List<ExternalDTO>

    abstract fun fetch(page: Int): List<ExternalDTO>
}