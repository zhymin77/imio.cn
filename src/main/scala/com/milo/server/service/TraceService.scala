package com.milo.server.service

import com.milo.server.beans.TraceProtos.Trace.Builder
import com.milo.server.data.TraceData
import com.milo.server.utils.Timestamp

object TraceService extends BaseService {

  def insert(blogId: String, ip: String) = {
    TraceData.insert(blogId.toLong, Timestamp.currentUnixTime, ip)
  }
}
