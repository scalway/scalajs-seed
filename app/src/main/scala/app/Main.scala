package app

import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("Main")
object Main extends js.Object {
  def hello(str: String): Unit = dom.document.body.innerHTML = str
  def main(args: Array[String] = Array.empty): Unit = {
    println("Hello World")
  }
}
