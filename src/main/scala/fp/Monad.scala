package fp

object Monad extends App {

  val numbers = List(1, 2, 3, 4)

  val incrementer = (x: Int) => List(x + 1)
  val doubler = (x: Int) => List(x * 2)

  val doubledIncrementedList = numbers.flatMap(incrementer).flatMap(doubler)
  println(doubledIncrementedList)

  val name = "Alex"

}
