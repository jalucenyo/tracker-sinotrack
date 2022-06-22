package com.lucenyo.tracker.sinotrack.infrastructure.config

import com.lucenyo.tracker.sinotrack.domain.usecases.ReceivedLocationUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.config.EnableIntegration
import org.springframework.integration.dsl.IntegrationFlow
import org.springframework.integration.dsl.IntegrationFlows
import org.springframework.integration.ip.dsl.Tcp
import org.springframework.integration.ip.tcp.connection.AbstractServerConnectionFactory
import org.springframework.integration.ip.tcp.connection.TcpNioServerConnectionFactory
import org.springframework.integration.ip.tcp.serializer.ByteArrayCrLfSerializer
import org.springframework.integration.ip.tcp.serializer.ByteArrayLfSerializer
import org.springframework.integration.ip.tcp.serializer.ByteArrayRawSerializer
import org.springframework.integration.ip.tcp.serializer.ByteArraySingleTerminatorSerializer

@Configuration
@EnableIntegration
class InboundTcpServerConfig(
  @Value("\${inbound.tcp-port}")
  val tcpServerPort: Int,
  val receivedLocationUseCase: ReceivedLocationUseCase
) {

  val log: Logger = LoggerFactory.getLogger(this::class.java)

  @Bean
  fun inboundData(): IntegrationFlow {
    return IntegrationFlows.from(Tcp.inboundGateway(connectionFactory()))
      .handle<ByteArray> { payload, headers ->
        log.debug("TCP Received: {} ", String(payload))
        receivedLocationUseCase(String(payload))
      }.get()
  }

  fun connectionFactory(): AbstractServerConnectionFactory {
    val server = TcpNioServerConnectionFactory(tcpServerPort)
    server.deserializer = ByteArrayRawSerializer()
    return server
  }

}