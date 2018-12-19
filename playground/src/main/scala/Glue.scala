

object Glue extends App {

  def f(a: Int): (Int, String) = (a, s"f($a)=$a")
  def g(a: Int): (Int, String) = (2*a, s"g($a)=2*$a=${2*a}")
  def h(a: Int): (Int, String) = (2*a, s"h($a)=3*$a=${3*a}")


  val fResult = f(100)
  val gResult = bind(g, fResult)
  val hResult = bind(h, gResult)

  printResult(hResult)

  def printResult(t: (Int, String)): Unit = println(s"Result: ${t._1}, debug message: '${t._2}'")

  def bind(f: Int => (Int, String), tuple: (Int, String)): (Int, String) = {
    val res = f(tuple._1)

    (res._1, tuple._2 + '\n' + res._2 )
  }


}
