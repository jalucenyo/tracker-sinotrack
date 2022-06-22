package com.lucenyo.tracker.sinotrack.domain.parsers

import com.lucenyo.tracker.sinotrack.domain.models.QualitySignalEnum

fun parseQuality(payload: String): String {
  val quality = Regex(",([A,V]),").find(payload)?.groups?.get(1)?.value!!
  return QualitySignalEnum.valueOf(quality).code
}
