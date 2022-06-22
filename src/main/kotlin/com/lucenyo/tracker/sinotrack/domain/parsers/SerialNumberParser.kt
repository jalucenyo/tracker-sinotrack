package com.lucenyo.tracker.sinotrack.domain.parsers


fun serialNumberParser(payload: String): String {
  return Regex(",([0-9]{10}),").find(payload)?.groups?.get(1)?.value!!
}
