package com.milo.server.service

import com.milo.server.beans.BlogProtos.Blog.Builder
import com.milo.server.convertors.BlogConvertor
import com.milo.server.data.BlogData
import com.milo.server.utils.Timestamp

object BlogService extends BaseService {

  def save(is: java.io.InputStream) = {
    val blog = BlogConvertor.toBlog(is)
    blog.setTimestamp(Timestamp.currentUnixTime)
    BlogData.save(blog.build)
  }

  def findAll = BlogData.findAll

  def findFullById(id: String, ip: String) = {
    TraceService.insert(id, ip)
    BlogData.review(id)
    BlogData.findFullById(id)
  }
}
