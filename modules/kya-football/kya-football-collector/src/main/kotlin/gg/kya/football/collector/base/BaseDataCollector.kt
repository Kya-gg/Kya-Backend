package gg.kya.football.collector.base

import org.slf4j.LoggerFactory

abstract class BaseDataCollector<ExternalDTO, InternalDTO>(
    protected val dataConverter: BaseDataConverter<ExternalDTO, InternalDTO>,
    protected val dataFetcher: BaseDataFetcher<ExternalDTO>,
) {
    private val logger = LoggerFactory.getLogger(BaseDataCollector::class.java)

    open fun collect() {
        val externalData = dataFetcher.fetch()
        val internalData = dataConverter.convert(externalData)
        save(internalData)

        logger.info("Data collected and saved ${internalData.size} items")
    }

    abstract fun save(data: List<InternalDTO>)
}