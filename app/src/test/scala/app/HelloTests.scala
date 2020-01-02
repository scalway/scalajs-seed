package app

import app.Main
import org.scalajs.dom
import utest._

object HelloTests extends TestSuite {
  val tests = Tests {
    test("Hello.world") - {
      Main.hello("Scala")
      val body = dom.document.body.innerHTML
      assert(body == "Hello, Scala!")
    }
  }
}
