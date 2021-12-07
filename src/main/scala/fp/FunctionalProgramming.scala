package fp

import scala.util.{Failure, Success, Try}

object FunctionalProgramming extends App {

  class Person(name: String) {
    def apply(age: Int): Unit = println(s"I have aged with $age")
  }

  val bob = new Person("Bob")
  bob.apply(42)
  bob(43)

  //Accepts Int and returns Int (pure function)
  val simpleIncrementer = new (Int => Int) {
    override def apply(value: Int): Int = value + 1
  }

  //Can be invoked as
  simpleIncrementer.apply(1)
  //Or directly as
  simpleIncrementer(23)

  //Accepts two args of type Int and returns an Int
  val doubler: (Int, Int) => Int = (x: Int, y: Int) => (x + y) * 2
  println(doubler(5, 6))

  val list = List(1, 2, 3, 4, 5)
  val mappedList = list.map(x => x + 1)
  println(mappedList)

  val numbers = List(1, 2, 3, 4, 5)
  val filteredList = numbers.filter(x => x > 3)
  println(filteredList)
  val filteredList2 = numbers.filter(_ > 3)
  println(filteredList2)

  val letters = List('A', 'B', 'C', 'D', 'F')
  val allPairs = list.map(number => letters.map(letter => s"$number-$letter"))
  println(allPairs)

  val alternativePairs = for {
    number <- 1 to letters.size
    letter <- letters
  } yield s"$number-$letter"
  println(alternativePairs)

  val aPrependedList = 0 :: list
  val anExtendedList = 0 +: list :+ 10
  println(aPrependedList)
  println(anExtendedList)

  val aSet = Set(1, 2, 3, 4, 1, 2, 3)
  val setHas5 = aSet.contains(4)
  println(setHas5)
  val aRange = 1 to 10
  val twoByTwo = aRange.map(x => 2 * x).toList
  println(twoByTwo)


  def myExceptionalMethod(): Int = throw new RuntimeException

  Try(myExceptionalMethod()) match {
    case Success(value) => println(s"Everything is OK! Here is the value: $value")
    case Failure(exception) => println(s"I have some bad news for you fella ${exception.getCause}")
  }
}
