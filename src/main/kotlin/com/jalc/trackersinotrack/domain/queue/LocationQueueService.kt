package com.jalc.trackersinotrack.domain.queue

import com.jalc.trackersinotrack.domain.models.Location

interface LocationQueueService {

  fun send(location: Location)

}