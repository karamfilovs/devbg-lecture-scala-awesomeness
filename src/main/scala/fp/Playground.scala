package fp

import com.google.gson.{Gson, GsonBuilder}
import fp.Playground.Animal

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Playground extends App {

  //Normal class
  class Person(val name: String) {
    def something() = {

    }
  }


  //Data classes with getters/setters out of the box
  case class Car(make: String, fuelType: String)

  //Interface
  trait Animal {
    def walk(distance: Double)
  }

  //Instance of person class
  val personX = new Person("Ivan")
  println(personX.name)
  //A single object of type Person
  //Immutable instance of car class
  val bmw525 = Car("BMW", "diesel")
  println(bmw525.make)
  println(bmw525.fuelType)

  //Code block
  val number: Int = {
    println("Something")
    5
  }

  val Gson = new GsonBuilder().setPrettyPrinting().create()

  println(Gson.toJson(bmw525))

  val aFuture = Future {
    //I have to wait for this code to execute
  }

  val human = new Human("Alex")
  human.walk(10)

}

class Human(val name: String) extends Animal {
  override def walk (distance: Double) = {
    println(s"The human walked $distance miles")
    """ {
      |"name":
      |} """.stripMargin
  }
}
