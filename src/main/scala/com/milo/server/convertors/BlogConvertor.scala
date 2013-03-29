package com.milo.server.convertors

import com.milo.server.beans.BlogProtos._

object BlogConvertor {

  def toBlog(bytes: Array[Byte]/*is: InputStream*/) =
    Blog.newBuilder.mergeFrom(bytes)
}
