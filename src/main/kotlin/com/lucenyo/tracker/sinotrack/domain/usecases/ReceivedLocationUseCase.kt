package com.lucenyo.tracker.sinotrack.domain.usecases

import com.lucenyo.tracker.sinotrack.domain.models.Location
import com.lucenyo.tracker.sinotrack.domain.parsers.parseDateTime
import com.lucenyo.tracker.sinotrack.domain.parsers.parseLatitude
import com.lucenyo.tracker.sinotrack.domain.parsers.parseLongitude
import com.lucenyo.tracker.sinotrack.domain.parsers.parseQuality
import com.lucenyo.tracker.sinotrack.domain.parsers.parseSpeed
import com.lucenyo.tracker.sinotrack.domain.parsers.serialNumberParser
import com.lucenyo.tracker.sinotrack.domain.queue.LocationQueueService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ReceivedLocationUseCase(
  val locationQueueService: LocationQueueService
) {

  val log: Logger = LoggerFactory.getLogger(this::class.java)

  operator fun invoke(payload: String){

    log.info("Received location payload: {}", payload)

    try {

      payload.split("*")
        .filter { it.isNotBlank() }
        .map {
          Location(
            raw = it,
            serialNumber = serialNumberParser(it),
            datetime = parseDateTime(it),
            latitude = parseLatitude(it),
            longitude = parseLongitude(it),
            quality = parseQuality(it),
            speed = parseSpeed(it)
          )
        }
        .forEach {
          locationQueueService.send(it)
        }

    }catch (exception: Exception) {
      log.error("Error received location: {}", exception.message)
    }
  }

}
