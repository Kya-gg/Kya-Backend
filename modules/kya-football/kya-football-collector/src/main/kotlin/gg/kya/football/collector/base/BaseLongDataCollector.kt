package gg.kya.football.collector.base

import gg.kya.football.common.base.LongDataService
import gg.kya.football.common.base.LongIdDTO

abstract class BaseLongDataCollector<ExternalDTO, InternalDTO : LongIdDTO>(
    dataConverter: BaseDataConverter<ExternalDTO, InternalDTO>,
    dataFetcher: BaseDataFetcher<ExternalDTO>,
    private val dataService: LongDataService<InternalDTO>
) : BaseDataCollector<ExternalDTO, InternalDTO>(dataConverter, dataFetcher) {
    override fun save(data: List<InternalDTO>) {
        data.forEach(dataService::upsert)
    }
}