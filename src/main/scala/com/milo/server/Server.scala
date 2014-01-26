package com.milo.server

import com.milo.server.intents._

import unfiltered.netty._
import unfiltered.request._
import unfiltered.response._

object Server {
  def main(args: Array[String]) = {
    println("start listening on port: " + ServerSetting.port)
    unfiltered.netty.Http(ServerSetting.port)
      .plan(asyncPlanify(
      CommentIntent.save,
      LoginIntent.auth,
      BlogIntent.edit,
      BlogIntent.info,
      MainIntent.index
    )).chunked(5*1024*1024).plan(asyncPlanify(BlogIntent.save))
    .plan(async.Planify {
        case req => req.respond(Redirect("/"))
      }).run()
  }

  import unfiltered.netty.async.Plan.Intent
  import com.milo.server.overrides.Planify
  def asyncPlanify(head: Intent, tail: Intent*) = Planify {
    tail.fold(head) { _ onPass _ }
  }
}
