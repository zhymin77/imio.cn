package com.milo.server.data

import com.milo.server.beans.TraceProtos._

import java.sql.{ Connection, PreparedStatement, ResultSet, Statement }

import scala.collection.mutable.ListBuffer

object TraceData extends BaseData {

  def insert(blogId: Long, timestamp: Long, ip: String) = {
    var conn: Connection = null
    var ppmt: PreparedStatement = null
    try {
      conn = getConnection
      conn.setAutoCommit(false)
      ppmt = conn.prepareStatement(SQL.Insert)
      ppmt.setLong(1, blogId)
      ppmt.setLong(2, timestamp)
      ppmt.setString(3, ip)
      ppmt.execute
      conn.commit
    } catch {
      case e: Exception =>
        if (conn != null) conn.rollback
        throw e
    } finally {
      close(null, ppmt, conn)
    }
  }

  object SQL {
    val table = "tb_trace"
    val Insert = "insert into " + table + " (blogId, timestamp, ip) values(?, ?, ?)"
  }
}
