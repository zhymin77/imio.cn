package com.milo.server.intents

import com.milo.server.utils.ScalateSupport

import unfiltered.request._
import unfiltered.response._

abstract class BaseIntent extends ScalateSupport {
  protected val SUCCESS = "success"
  protected val FAILED = "failed"

  object Decode {
    def unapply(s: String): Option[String] = Some(decode(s))
  }

  def decode(s: String) = java.net.URLDecoder.decode(s, "utf-8")
  def encode(s: String) = java.net.URLEncoder.encode(s, "utf-8")
}
