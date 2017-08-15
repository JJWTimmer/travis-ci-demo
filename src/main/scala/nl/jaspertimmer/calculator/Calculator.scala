package nl.jaspertimmer.calculator

import com.redis._
import serialization._
import Parse.Implicits._

class Calculator(redisHost: String, redisPort: Int) {
  val r = new RedisClient(redisHost, redisPort)

  def sum(a: Int, b: Int): Int = a + b
  def sub(a: Int, b: Int): Int = a - b
  def store(x: Int): Boolean   = r.set("memory", x)
  def restore: Option[Int]     = r.get[Int]("memory")
}
