package com.milo.server.utils

import java.io.{ File, OutputStreamWriter, PrintWriter }
import com.milo.server.ServerSetting

import org.fusesource.scalate.Binding
import unfiltered.response.ResponseWriter

trait ScalateSupport {
  protected def scalateDefaultLayoutUri: String = "layout.ssp"
  protected def scalateDefaultTemplateDirs: List[File] =
    new File(ServerSetting.templates) :: Nil
  protected lazy val scalateEngine =
    new ScalateTemplateEngine(scalateDefaultLayoutUri, scalateDefaultTemplateDirs: _*)

  def render(uri: String,
    attributes: Map[String, Any] = Map(), s: S = null, extraBindings: Traversable[Binding] = Nil)
    (implicit defaultAttributes: Map[String, Any]) =
      new ResponseWriter {
        def write(writer: OutputStreamWriter) {
          val printWriter = new PrintWriter(writer)
          try {
            val sMap = if (s != null) Map("username" -> s.username, "isLogin" -> s.isLogin)
              else Map()
            scalateEngine.renderWithWriter(uri, printWriter,
              attributes ++ defaultAttributes ++ sMap, extraBindings)
          } catch {
            case e if scalateEngine.isDevelopmentMode =>
            printWriter.println("<pre>")
            printWriter.println(extraBindings.toList)
            printWriter.println("</pre>")
            printWriter.println("<br>")
            printWriter.println("<pre>")
            printWriter.println("Exception: " + e.getMessage)
            e.getStackTrace.foreach(printWriter.println)
            printWriter.println("</pre>")
            case e => throw e
          }
        }
      }

  def renderToString(uri: String,
    attributes: Map[String, Any] = Map())
    (implicit defaultAttributes: Map[String, Any]) =
    scalateEngine.render(uri, attributes ++ defaultAttributes)

  object URLDecode {
    def unapply(s: String): Option[String] = Some(java.net.URLDecoder.decode(s, "utf-8"))
  }

  implicit def bindingAttributes: Map[String, Any] = Map(
    "domain" -> ServerSetting.domain,
    "resourceDomain" -> (ServerSetting.domain + "/assets")
  )
}
