package com.milo.server.data

import com.milo.server.beans.TraceProtos._

import java.sql.{ Connection, PreparedStatement, ResultSet, Statement }

import scala.collection.mutable.ListBuffer

object TraceData extends BaseData {

  def insert(blogId: Long, timestamp: Long, ip: String) = withCColl(SQL.Insert) { ppmt =>
    ppmt.setLong(1, blogId)
    ppmt.setLong(2, timestamp)
    ppmt.setString(3, ip)
  }

  object SQL {
    val table = "tb_trace"
    val Insert = "insert into " + table + " (blogId, timestamp, ip) values(?, ?, ?)"
  }
}
