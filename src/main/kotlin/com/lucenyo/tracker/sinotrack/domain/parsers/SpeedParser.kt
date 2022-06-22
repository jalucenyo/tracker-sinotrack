package com.lucenyo.tracker.sinotrack.domain.parsers


fun parseSpeed(payload: String): Double {
  return Regex(",([0-9]{3}\\.[0-9]{2}),").find(payload)?.groups?.get(1)?.value!!.toDouble()
}
