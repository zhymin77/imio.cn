package com.milo.server.service

import com.milo.server.beans.CommentProtos.Comment.Builder
import com.milo.server.convertors.CommentConvertor
import com.milo.server.data.CommentData
import com.milo.server.utils.Timestamp

object CommentService extends BaseService {

  def save(is: java.io.InputStream, userId: Long = 0) = {
    val comment = CommentConvertor.toComment(is)
    comment.setTimestamp(Timestamp.currentUnixTime)
    comment.setUserId(userId)
    CommentData.insert(comment.build)
  }

  def findByBlogId(blogId: String) = CommentData.findByBlogId(blogId)
}
