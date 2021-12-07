package calculator

import com.google.gson.GsonBuilder

class Calculator {

  def sum(left: Int, right: Int): Int = left + right

  def divide(left: Int, right: Int): Int = left / right

  def multiply(left: Int, right: Int): Int = left * right

  def subtract(left: Int, right: Int): Int = left - right
}


case class Client(firstName: String, lastName: String, age: Int = 20)

object Test extends App {
  val name = "Alex"
  val age = 30
  println(name)
  println(age)
  val pragmatic = Client("Alex", "Karamfilov", 37)
  val Gson = new GsonBuilder().setPrettyPrinting().create()
  println(Gson.toJson(pragmatic))
  val json =
    """ {
      | "firstName": "Ivan",
      | "lastName": "Ivanov",
      | "age": 30
      |} """.stripMargin
  val client2 = Gson.fromJson(json, classOf[Client])
  println(client2.firstName)
  println(client2.lastName)
  println(client2.age)
  println(s"The client first name is: ${client2.firstName}")
  println(s"The client first name is: $age")
}

trait Animal {
  def run()
}

class Dog extends Animal {
  override def run(): Unit = {
    println("The dog is running fast")
  }
}

object Human {
  def walk(miles: Double): Unit = {

  }
}

