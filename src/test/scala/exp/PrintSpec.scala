package exp

import org.scalatest.FunSuite

import scala.language.implicitConversions

class PrintSpec extends FunSuite {

  implicit def intToNumber(n: Int): Number = Number(n)
  implicit def stringToVariable(name: String): Variable= Variable(name)

  def sum(terms: Expression*) = Sum(terms.toList)

  test("single number") {
    val exp = Number(10)
    assert(print(exp) == "10")
  }

  test("single variable") {
    val exp = Variable("x")
    assert(print(exp) == "x")
  }

  test("sum of numbers") {
    val exp = sum(1, 2, 3)
    assert(print(exp) == "1 + 2 + 3")
  }

  test("sum of numbers and variables") {
    val exp = sum(1, "a", 3, "b")
    assert(print(exp) == "1 + a + 3 + b")
  }

  test("sum of sums") {
    val exp = sum(sum(1, "a"), sum(3, "b"))
    assert(print(exp) == "1 + a + 3 + b")
  }
}
