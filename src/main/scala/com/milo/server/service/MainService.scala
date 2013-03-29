package com.milo.server.service

import com.milo.server.data.BlogData

object MainService extends BaseService {

  def main = {
    val blogs = BlogData.findAll
    Map (
      "blogs" -> blogs
    )
  }
}
