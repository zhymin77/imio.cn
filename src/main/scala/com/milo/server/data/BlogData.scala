package com.milo.server.data

import com.milo.server.beans.BlogProtos._

import java.io.ByteArrayInputStream

import scala.collection.mutable.ListBuffer

object BlogData extends BaseData {

  def review(blogId: String) = withUColl(SQL.Review(blogId))

  def save(blog: Blog) = withCColl(SQL.Insert) { ppmt =>
    ppmt.setString(1, blog.getBlogType.toString)
    ppmt.setString(2, blog.getTitle)
    ppmt.setString(3, blog.getBrief)
    ppmt.setLong(4, blog.getTimestamp)
    ppmt.setBlob(5, new ByteArrayInputStream(blog.toByteArray))
  }

  def findFullById(id: String) = withRColl(SQL.QueryFullById(id)) { rs =>
    if (rs.next) {
      val blog = Blog.newBuilder.mergeFrom(Blog.parseFrom(rs.getBinaryStream("data")))
      blog.setReview(rs.getInt("review"))
      blog.build
    } else {
      null
    }
  }

  def findAll = withRColl(SQL.QueryAll) { rs =>
    val listBuffer = ListBuffer[Blog]()
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
  }

  object SQL {
    val table = "tb_blog"
    val Insert = "insert into " + table + " (type, title, brief, timestamp, data) values(?, ?, ?, ?, ?)"
    //val QueryAll = "select id, timestamp, type, title, brief, review from " + table + " order by timestamp ASC"
    val QueryAll = "select id, timestamp, type, title, brief, review from " + table + " order by timestamp DESC"

    def QueryFullById(id: String) = "select data, review from " + table + " where id='%s'".format(id)

    def Review(id: String) = "update " + table + " set review=review+1 where id='%s'".format(id)
  }
}
