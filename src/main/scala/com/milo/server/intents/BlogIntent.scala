package com.milo.server.intents

import com.milo.server.utils.WithS
import com.milo.server.service.BlogService
import com.milo.server.service.CommentService

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
      req.respond(ResponseString(SUCCESS))
  }
  val info = unfiltered.netty.async.Intent {
    case req@GET(Path(Seg("findblog" :: blogId :: Nil))) & Params(p) & WithS(s) =>
      val blog = BlogService.findFullById(blogId, req.headers("X-Real-IP").next)
      val comments = CommentService.findByBlogId(blogId)
      val map = Map("blog" -> blog, "blogId" -> blogId, "comments" -> comments)
      req.respond(HtmlContent ~> render("blog/show.ssp", map, s))
  }
}
