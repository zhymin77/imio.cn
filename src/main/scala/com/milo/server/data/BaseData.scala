package com.milo.server.data

import com.milo.server.ServerSetting

import java.sql.{ Connection, DriverManager, ResultSet, Statement }

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

  def close(rs: ResultSet, stmt: Statement, con: Connection) = {
    try {
      if (rs != null && !rs.isClosed) rs.close
    } catch {
      case e: Exception =>
        if (rs!= null && !rs.isClosed) rs.close
    } finally {
      try {
        if (rs!= null && !rs.isClosed) rs.close
      } catch {
        case e: Exception => println(e.getMessage)
      }
    }
    try {
      if (stmt != null && !stmt.isClosed) stmt.close
    } catch {
      case e: Exception =>
        if (stmt!= null && !stmt.isClosed) stmt.close
    } finally {
      try {
        if (stmt!= null && !stmt.isClosed) stmt.close
      } catch {
        case e: Exception => println(e.getMessage)
      }
    }
    try {
      if (con != null && !con.isClosed) con.close
    } catch {
      case e: Exception =>
        if (con != null && !con.isClosed) con.close
    } finally {
      try {
        if (con != null && !con.isClosed) con.close
      } catch {
        case e: Exception => println(e.getMessage)
      }
    }
  }
}
