package example

import akka.actor.ActorSystem
import akka.cluster.Cluster
import akka.http.scaladsl.Http
import com.typesafe.config.ConfigFactory

import scala.concurrent.duration.Duration
import scala.concurrent.{ Await, ExecutionContextExecutor }

object Main extends App {

  val config = ConfigFactory.load()

  implicit val system: ActorSystem                  = ActorSystem("ExampleSystem")
  implicit val dispatcher: ExecutionContextExecutor = system.dispatcher

  val cluster = Cluster(system)
  cluster.registerOnMemberUp {
    val route = new AccountRoute(system).route
    Http().newServerAt(config.getString("http.host"), config.getInt("http.port")).bind(route)
  }
  Await.result(system.whenTerminated, Duration.Inf)
}
