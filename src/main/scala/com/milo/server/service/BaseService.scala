package com.milo.server.service

abstract class BaseService {

  implicit def InputStreamToByteArray(is: java.io.InputStream): Array[Byte] =
    new sun.misc.BASE64Decoder().decodeBuffer(is)
}
