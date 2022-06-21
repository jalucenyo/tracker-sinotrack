package com.jalc.trackersinotrack.infrastructure.queue

import com.amazonaws.services.sqs.AmazonSQSAsync
import com.jalc.trackersinotrack.domain.models.Location
import com.jalc.trackersinotrack.domain.queue.LocationQueueService
import io.awspring.cloud.messaging.core.QueueMessagingTemplate
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service


@Service
class AwsSQSQueueServiceImpl(
  val awsSqsService: AmazonSQSAsync,
  @Value("\${spring.application.name}") val applicationName: String,
  @Value("\${queue.destination}") val destinationName: String
): LocationQueueService {

  val log: Logger = LoggerFactory.getLogger(this::class.java)

  override fun send(location: Location) {

    log.info("Send message to aws sqs: {}", location)

    val channel = QueueMessagingTemplate(awsSqsService)

    val msg = MessageBuilder.withPayload(location)
      .setHeader("sender", applicationName)
      .build()

    return channel.convertAndSend(destinationName, msg);

  }

}
