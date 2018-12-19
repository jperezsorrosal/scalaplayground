import java.util.concurrent.Executors

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

object TestFuture extends App {

  val pool = Executors.newCachedThreadPool()
  implicit val ec = ExecutionContext.fromExecutorService(pool)

  val f1 = Future { Thread.sleep(10*1000); println(1); 1 }
  val f2 = Future { Thread.sleep(2*1000);  println(2); 2 }
  val f3 = Future { Thread.sleep(4*1000);  println(3); 3 }

  val result = for {
    r1 <- f1
    r2 <- f2
    r3 <- f3
  } yield (r1 + r2 + r3)

  result.onComplete {
    case Success(x) =>
      println(s"\nresult = $x")
      ec.shutdown()
    case Failure(e) =>
      e.printStackTrace
      ec.shutdown()
  }


}
