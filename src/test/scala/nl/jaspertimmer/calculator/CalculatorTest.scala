package nl.jaspertimmer.calculator

import com.typesafe.config.ConfigFactory

class CalculatorTest extends org.scalatest.FunSuite {

  val conf       = ConfigFactory.load()
  val calculator = new Calculator(conf.getString("redis.host"), conf.getInt("redis.port"))

  test("It should sum a bit") {
    assert(123 + 321 == calculator.sum(123, 321), "The sums do not match")
  }
  test("It should substract a bit") {
    assert(321 - 123 == calculator.sub(321, 123), "The substractions do not match")
  }

  test("It should store a number and retrieve it") {
    calculator.restore === None
    calculator.store(777) === true
    calculator.restore === Some(777)
  }
}
