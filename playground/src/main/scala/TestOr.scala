import org.scalactic.{Bad, ErrorMessage, Good, Or}

object TestOr extends App {
  def makeInt(s: String): Int Or ErrorMessage = {
    try {
      Good(s.trim.toInt)
    } catch {
      case e: Exception => Bad(e.toString)
    }
  }

  val t: Or[Int, ErrorMessage] = makeInt("77")
  t foreach(println)
}
