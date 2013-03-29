package com.milo.server

import com.typesafe.config._

object ServerSetting {
  lazy val config = {
    val path = System.getProperty("serverConfig")
    ConfigFactory.parseString(scala.io.Source.fromFile(path).getLines.reduceLeft(_ + "\n" + _))
  }

  val port = config.getInt("server.port")
  val mode = config.getString("server.mode")
  val isDevMode = mode.toLowerCase.equals("dev")
  val isProdMode = mode.toLowerCase.equals("prod")

  val templates = config.getString("server.templates")
  val domain = "http://" + config.getString("server.domain")

  val dbDomain = config.getString("server.dbdomain")
}
