package com.milo.server.data

import com.milo.server.beans.BlogProtos._

import java.io.ByteArrayInputStream
import java.sql.{ Connection, PreparedStatement, ResultSet, Statement }

import scala.collection.mutable.ListBuffer

object BlogData extends BaseData {

  def save(blog: Blog) = {
    var conn: Connection = null
    var ppmt: PreparedStatement = null
    try {
      conn = getConnection
      conn.setAutoCommit(false)
      ppmt = conn.prepareStatement(SQL.Insert)
      ppmt.setString(1, blog.getBlogType.toString)
      ppmt.setString(2, blog.getTitle)
      ppmt.setString(3, blog.getBrief)
      ppmt.setLong(4, blog.getTimestamp)
      ppmt.setBlob(5, new ByteArrayInputStream(blog.toByteArray))
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

  def findFullById(id: String) = {
    var conn: Connection = null
    var stmt: Statement = null
    var rs: ResultSet = null
    try {
      conn = getConnection
      stmt = conn.createStatement
      rs = stmt.executeQuery(SQL.QueryFullById(id))
      if (rs.next) {
        Blog.parseFrom(rs.getBinaryStream("data"))
      } else {
        null
      }
    } catch {
      case e: Exception =>
        e.printStackTrace
    } finally {
      close(rs, stmt, conn)
    }
  }


  def findAll = {
    val listBuffer = ListBuffer[Blog]()
    var conn: Connection = null
    var stmt: Statement = null
    var rs: ResultSet = null
    try {
      conn = getConnection
      stmt = conn.createStatement
      rs = stmt.executeQuery(SQL.QueryAll)
      while (rs.next) {
        val builder = Blog.newBuilder
        builder.setId(rs.getLong(1))
        builder.setTimestamp(rs.getLong(2))
        builder.setBlogType(BlogType.valueOf(rs.getString(3)))
        builder.setTitle(rs.getString(4))
        builder.setBrief(rs.getString(5))
        builder.setReview(rs.getInt(6))
        listBuffer += builder.build
      }
      listBuffer.toList
    } catch {
      case e: Exception =>
        e.printStackTrace
    } finally {
      close(rs, stmt, conn)
    }
  }

  object SQL {
    val table = "tb_blog"
    val Insert = "insert into " + table + " (type, title, brief, timestamp, data) values(?, ?, ?, ?, ?)"
    val QueryAll = "select id, timestamp, type, title, brief, review from " + table + " order by timestamp ASC"

    def QueryFullById(id: String) = "select data from " + table + " where id='%s'".format(id)
  }
}
