package com.lucenyo.tracker.sinotrack.domain.parsers

fun parseLatitude(payload: String): Double {
  val dms = Regex(",([0-9]{2})([0-9]{2}\\.[0-9]{4}),([N,S]),").find(payload)?.groups!!
  val degree =  dms[1]?.value!!.toDouble()
  val minute = dms[2]?.value!!.toDouble()
  val direction = dms[3]?.value!!.replace("S", "-1").replace("N", "1").toDouble()
  return (degree + (minute/60)) * direction
}
