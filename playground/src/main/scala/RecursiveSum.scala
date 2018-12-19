object RecursiveSum extends App {
  def sum(list: List[Int]): Int = list match {
    case Nil => 0
    case x :: xs => x + sum(xs)
  }
  val list = List.range(1, 10000)  // MUCH MORE DATA
  val x = sum(list)
  println(x)
}