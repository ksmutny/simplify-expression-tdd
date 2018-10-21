package exp

import org.scalatest.FunSuite

class PrintSpec extends FunSuite {

  test("single number") {
    val exp = Number(10)
    assert(print(exp) == "10")
  }
}
