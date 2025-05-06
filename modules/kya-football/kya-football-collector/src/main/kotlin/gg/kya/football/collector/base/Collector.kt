package gg.kya.football.collector.base

abstract class Collector<InternalDTO> {
    protected abstract fun saveAll(dtoList: List<InternalDTO>)
}