package nl.jaspertimmer.calculator

object Boot extends App {
  val calculator = new Calculator
  println(s"123 + 321 = ${calculator.sum(123, 321)}")
  println(s"321 - 123 = ${calculator.sub(321, 123)}")
}
