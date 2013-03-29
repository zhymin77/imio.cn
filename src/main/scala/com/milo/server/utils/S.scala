package com.milo.server.utils

import unfiltered.netty._
import unfiltered.request._

object WithS {
  def unapply[T](req: HttpRequest[T]): Option[S] = req match {
    case r: RequestBindingWithS => Some(r.s)
    case _ => None
  }
}

class S(m: ReceivedMessage) {
  var userId: Long = 0L
  var username: String = _
  var isLogin: Boolean = false
}

class RequestBindingWithS(m: ReceivedMessage) extends RequestBinding(m) {
  def s: S = sObject
  lazy val sObject = new S(m)
}
