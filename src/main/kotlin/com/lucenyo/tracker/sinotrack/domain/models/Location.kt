package com.lucenyo.tracker.sinotrack.domain.models

data class Location(
  val raw: String,
  val serialNumber: String,
  val datetime: String,
  val latitude: Double,
  val longitude: Double,
  val quality: String,
  val speed: Double,
)
