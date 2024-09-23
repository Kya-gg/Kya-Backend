package gg.kya.football.collector.base

abstract class BaseDataConverter<ExternalDTO, InternalDTO> {
    abstract fun convert(response: List<ExternalDTO>): List<InternalDTO>
}