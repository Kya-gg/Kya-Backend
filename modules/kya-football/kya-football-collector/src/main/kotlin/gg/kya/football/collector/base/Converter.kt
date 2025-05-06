package gg.kya.football.collector.base

import gg.kya.football.collector.DataProvider

interface Converter<InternalDTO, ExternalDTO> {
    fun convert(externalDTO: ExternalDTO, dataProvider: DataProvider): InternalDTO

    fun convertBatch(externalDTOs: List<ExternalDTO>, dataProvider: DataProvider): List<InternalDTO> {
        return externalDTOs.map { convert(it, dataProvider) }
    }
}