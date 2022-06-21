package com.jalc.trackersinotrack.domain.usecases

import com.jalc.trackersinotrack.domain.models.Location
import com.jalc.trackersinotrack.domain.queue.LocationQueueService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ReceivedLocationUseCase(
  val locationQueueService: LocationQueueService
) {

  val log: Logger = LoggerFactory.getLogger(this::class.java)

  operator fun invoke(payload: String){

    log.debug("Received location payload: {}", payload)

    locationQueueService.send(Location(
      raw = payload
    ))

  }

}