package com.lucenyo.tracker.sinotrack.domain.parsers

import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

fun parseDateTime(payload: String): String {

  val time = Regex(",.{2},([0-9]{6}),").find(payload)?.groups?.get(1)?.value!!
  val date = Regex(",.{3},([0-9]{6}),").find(payload)?.groups?.get(1)?.value!!

  return OffsetDateTime.parse("""${date} ${time}+0000""",
    DateTimeFormatter.ofPattern("ddMMyy HHmmssZ")).toString()

}
