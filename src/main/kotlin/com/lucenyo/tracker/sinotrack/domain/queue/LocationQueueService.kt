package com.lucenyo.tracker.sinotrack.domain.queue

import com.lucenyo.tracker.sinotrack.domain.models.Location

interface LocationQueueService {

  fun send(location: Location)

}