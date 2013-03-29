package com.milo.server.intents

import com.milo.server.utils.WithS
import com.milo.server.service.BlogService

import unfiltered.netty._
import unfiltered.request._
import unfiltered.response._

object BlogIntent extends BaseIntent {

  val edit = unfiltered.netty.async.Intent {
    case req@GET(Path("/blog/edit")) & WithS(s) =>
      req.respond(HtmlContent ~> render("blog/edit.ssp", Map(), s))
  }
  val save = unfiltered.netty.async.Intent {
    case req@POST(Path("/blog/save")) =>
      BlogService.save(Body.stream(req))
      req.respond(ResponseString("ok"))
  }
  val info = unfiltered.netty.async.Intent {
    case req@GET(Path(Seg("findblog" :: blogId :: Nil))) & WithS(s) =>
      val blog = BlogService.findFullById(blogId)
      val map = Map("blog" -> blog, "blogId" -> blogId)
      req.respond(HtmlContent ~> render("blog/show.ssp", map, s))
  }
}
