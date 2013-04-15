package com.milo.server.data

import com.milo.server.ServerSetting

import java.sql.{ Connection, DriverManager, ResultSet, Statement, PreparedStatement }

protected[data] abstract class BaseData {
  lazy val conn_str =
    "jdbc:mysql://" + ServerSetting.dbDomain + "/%s?user=root&password=20764116"

  def getConnection: Connection = {
    // load jdbc driver
    try {
      Class.forName("com.mysql.jdbc.Driver")
    } catch {
      case e: Exception => e.printStackTrace
    }
    try {
      DriverManager.getConnection(conn_str.format("imilo"))
    } catch {
      case e: Exception =>
        e.printStackTrace
        null
    }
  }

  def closeE[T](op: => T) = try { op } catch {
    case e: Exception => op
  } finally {
    try { op } catch {
      case e: Exception => println(e.getMessage)
    }
  }

  def close(rs: ResultSet, stmt: Statement, con: Connection) = {
    closeE(if (rs != null && !rs.isClosed) rs.close)
    closeE(if (stmt != null && !stmt.isClosed) stmt.close)
    closeE(if (con != null && !con.isClosed) con.close)
  }

  def withCColl(sql: String)(op: PreparedStatement => Unit): Boolean = {
    var conn: Connection = null
    var ppmt: PreparedStatement = null
    try {
      conn = getConnection
      conn.setAutoCommit(false)
      ppmt = conn.prepareStatement(sql)
      op(ppmt)
      val rs = ppmt.execute
      conn.commit
      rs
    } catch {
      case e: Exception =>
        if (conn != null) conn.rollback
        throw e
    } finally {
      close(null, ppmt, conn)
    }
  }
  def withRColl[T](sql: String)(op: ResultSet => T): T = {
    var conn: Connection = null
    var stmt: Statement  = null
    var rs: ResultSet    = null
    try {
      conn = getConnection
      stmt = conn.createStatement
      rs   = stmt.executeQuery(sql)
      op(rs)
    } catch {
      case e: Exception => throw e
    } finally {
      close(rs, stmt, conn)
    }
  }
  def withUColl[T](sql: String) = {
    var conn: Connection = null
    var stmt: Statement = null
    try {
      conn = getConnection
      stmt = conn.createStatement
      stmt.executeUpdate(sql)
    } catch {
      case e: Exception => e.printStackTrace
    } finally {
      close(null, stmt, conn)
    }
  }
}
