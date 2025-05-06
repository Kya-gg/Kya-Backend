package gg.kya.football.collector.base

interface Converter<InternalDTO, ExternalDTO> {
    fun convert(externalDTO: ExternalDTO): InternalDTO

    fun convertBatch(externalDTOs: List<ExternalDTO>): List<InternalDTO> {
        return externalDTOs.map { convert(it) }
    }
}