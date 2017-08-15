package nl.jaspertimmer.calculator

class CalculatorTest extends org.scalatest.FunSuite {

  val calculator = new Calculator

  test("It should sum a bit") {
    assert(123 + 321 == calculator.sum(123, 321), "The sums do not match")
  }
  test("It should substract a bit") {
    assert(321 - 123 == calculator.sub(321, 123), "The substractions do not match")
  }
}
