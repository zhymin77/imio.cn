package com.milo.server.intents

import com.milo.server.service.MainService
import com.milo.server.utils.WithS

import unfiltered.netty._
import unfiltered.request._
import unfiltered.response._

object MainIntent extends BaseIntent {

  val index = unfiltered.netty.async.Intent {
    case req@GET(Path("/")) & WithS(s) =>
      req.respond(HtmlContent ~> render("main/index.ssp", MainService.main, s))
    case req@GET(Path(Seg("index" :: Nil))) & WithS(s) =>
      req.respond(HtmlContent ~> render("main/index.ssp", MainService.main, s))
  }
}
