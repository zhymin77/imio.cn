package com.milo.server.intents

import com.milo.server.utils.WithS

import unfiltered.Cookie
import unfiltered.request._
import unfiltered.response._

object LoginIntent extends BaseIntent {

  val Token = "token"

  val auth = unfiltered.netty.async.Intent {
    case req@GET(Path("/tologin")) =>
      req.respond(HtmlContent ~> render("main/login.ssp", Map()))
    case req@POST(Path("/login") & Params(p)) =>
      val username = p("username").headOption.getOrElse("")
      val password = p("password").headOption.getOrElse("")
      if (username == "zhymin77" && password == "20764116")
        req.respond(Redirect("/") ~>
          SetCookies(Cookie(Token, username+"@"+password, maxAge = Some(60*60*24))))
      else req.respond(Redirect("/tologin"))
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
