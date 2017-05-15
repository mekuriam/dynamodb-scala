import java.util.concurrent.ExecutionException
import scala.concurrent.duration._

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global


/**
  * Created by mmekuria on 5/14/17.
  */
object Main extends App {

val aWSWrap = new AWSWrap
  runExample(aWSWrap)

  private def runExample(impl: AWSWrap): Unit = {
    println(s"*** Running example ${impl.title}")

    try {
      impl.createTable()

      val firstClient = Future {
        impl.registerItem("A", 0)
        impl.updateItemStatus("A")
      }
    /*  val secondClient = Future {
        impl.registerItem("B", 10)
        impl.updateItemStatus("B")
      }*/

      Await.result(Future.sequence(List(firstClient//,
        //secondClient
      )), 10.seconds)

      println(s"Result: ${impl.getItemStatus()}")
    }
    catch {
      case boxed: ExecutionException =>
        println(s"Failed: ${boxed.getCause}")
      case ex: Exception =>
        println(s"Failed: $ex")
    }
    finally {
      println("***")
      println()
    }
  }

}
