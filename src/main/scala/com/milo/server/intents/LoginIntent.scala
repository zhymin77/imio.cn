package com.milo.server.intents

import com.milo.server.utils.WithS

import unfiltered.Cookie
import unfiltered.request._
import unfiltered.response._

import scala.xml.Utility

object LoginIntent extends BaseIntent {

  val Token = "token"
  override def scalateDefaultLayoutUri: String = "laybody.ssp"

  val auth = unfiltered.netty.async.Intent {
    case req@GET(Path("/tologin")) =>
    req.respond(ResponseString(renderToString("login/login.ssp")))
    case req@GET(Path(Seg("login" :: username :: password :: Nil)) & Params(p)) =>
      if (username == "zhymin77" && password == "20764116")
        req.respond(SetCookies(Cookie(Token, username+"@"+password,
            maxAge = Some(60*60*24), path = Some("/"))) ~> ResponseString("ok"))
      else req.respond(ResponseString("no"))
    case req@GET(Path("/loginout")) =>
      req.respond(SetCookies.discarding(Token) ~> Redirect("/"))
    case req@Cookies(cookies) & WithS(s) if cookies.contains(Token) =>
      cookies(Token) match {
        case Some(c) =>
          val v = c.value
          if (v.contains("@")) {
            val la = v.split("@")
            if (la(0) == "zhymin77" && la(1) == "20764116") {
              s.username = la(0)
              s.isLogin = true
              Pass
            } else req.respond(Redirect("/"))
          } else req.respond(Redirect("/"))
        case _ => req.respond(Redirect("/"))
      }
  }
}
