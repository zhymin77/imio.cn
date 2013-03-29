package com.milo.server.convertors

import com.milo.server.beans.CommentProtos._

object CommentConvertor {

  def toComment(bytes: Array[Byte]) = Comment.newBuilder.mergeFrom(bytes)
}
