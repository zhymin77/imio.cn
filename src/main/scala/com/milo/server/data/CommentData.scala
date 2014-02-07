package com.milo.server.data

import com.milo.server.beans.CommentProtos._

import java.sql.{ Connection, PreparedStatement, ResultSet, Statement }

import scala.collection.mutable.ListBuffer

object CommentData extends BaseData {

  def insert(comment: Comment) = withCColl(SQL.Insert) { ppmt =>
    ppmt.setLong(1, comment.getBlogId)
    ppmt.setLong(2, comment.getUserId)
    ppmt.setLong(3, comment.getTimestamp)
    ppmt.setString(4, comment.getContent)
    ppmt.setLong(5, comment.getParentId)
    ppmt.setString(6, comment.getUsername)
    ppmt.setString(7, comment.getEmail)
  }

  def findByBlogId(bid: String) = withRColl(SQL.QueryByBlodId(bid)) { rs =>
    val listBuffer = ListBuffer[Comment]()
    while (rs.next) {
      val builder = Comment.newBuilder
      builder.setId(rs.getLong(1))
      builder.setBlogId(rs.getLong(2))
      builder.setUserId(rs.getLong(3))
      builder.setTimestamp(rs.getLong(4))
      builder.setContent(rs.getString(5))
      builder.setParentId(rs.getLong(6))
      builder.setUsername(rs.getString(7))
      builder.setEmail(rs.getString(8))
      listBuffer += builder.build
    }
    listBuffer.toList
  }

  object SQL {
    val table = "tb_comment"
    val Insert = "insert into " + table +
      " (blogId, userId, timestamp, content, parentId, username, email) values(?, ?, ?, ?, ?, ?, ?)"
    def QueryByBlodId(bid: String) = ("select id, blogId, userId, timestamp, content, parentId, username, email from "
      + table + " where blogId='%s' order by timestamp DESC").format(bid)
  }
}
