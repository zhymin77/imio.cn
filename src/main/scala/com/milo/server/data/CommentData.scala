package com.milo.server.data

import com.milo.server.beans.CommentProtos._

import java.sql.{ Connection, PreparedStatement, ResultSet, Statement }

import scala.collection.mutable.ListBuffer

object CommentData extends BaseData {

  def insert(comment: Comment) = {
    var conn: Connection = null
    var ppmt: PreparedStatement = null
    try {
      conn = getConnection
      conn.setAutoCommit(false)
      ppmt = conn.prepareStatement(SQL.Insert)
      ppmt.setLong(1, comment.getBlogId)
      ppmt.setLong(2, comment.getUserId)
      ppmt.setLong(3, comment.getTimestamp)
      ppmt.setString(4, comment.getContent)
      ppmt.setLong(5, comment.getParentId)
      ppmt.execute
      conn.commit
    } catch {
      case e: Exception =>
        if (conn != null) conn.rollback
        e.printStackTrace
    } finally {
      close(null, ppmt, conn)
    }
  }

  object SQL {
    val table = "tb_comment"
    val Insert = "insert into " + table +
      " (blogId, userId, timestamp, content, parentId) values(?, ?, ?, ?, ?)"
  }
}
