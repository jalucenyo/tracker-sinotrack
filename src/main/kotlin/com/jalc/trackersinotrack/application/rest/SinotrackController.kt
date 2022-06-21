package com.jalc.trackersinotrack.application.rest

import com.jalc.trackersinotrack.domain.usecases.ReceivedLocationUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/sinotrack")
class SinotrackController(
  val receivedLocationUseCase: ReceivedLocationUseCase
) {

  @PostMapping("/test")
  fun received(@RequestBody payload: String): ResponseEntity<Void> {

    receivedLocationUseCase(payload)
    return ResponseEntity.ok().build();

  }

}