package loops

object LoopsDemo extends App {

  //Standard loop
  for (i <- 1 to 10) {
    println("normal loop: " + i)
  }

  val numbers = List(1, 2, 3, 4, 5)

  val doubledNumbers = for {
    number <- numbers
  } yield number * 2

  doubledNumbers.foreach(println)
}
