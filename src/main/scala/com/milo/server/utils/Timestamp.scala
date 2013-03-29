package com.milo.server.utils

import java.text.SimpleDateFormat
import java.util.Date

object Timestamp {

  def currentUnixTime = System.currentTimeMillis / 1000

  def formatUnix(time: Long, format: String) =
    new SimpleDateFormat(format).format(new Date(time * 1000))

  def currentTimeMillis = System.currentTimeMillis

  def formatTime(time: Long, format: String) =
    new SimpleDateFormat(format).format(new Date(time))
}
