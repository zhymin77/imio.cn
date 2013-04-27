package com.milo.server.intents

import com.milo.server.utils.WithS
import com.milo.server.service.CommentService

import unfiltered.netty._
import unfiltered.request._
import unfiltered.response._

object CommentIntent extends BaseIntent {

  val save = unfiltered.netty.async.Intent {
    case req@POST(Path("/savecomment")) & WithS(s) =>
    CommentService.save(Body.stream(req), s.userId)
    req.respond(ResponseString(SUCCESS))
  }
}
