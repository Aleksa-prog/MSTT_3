import akka.actor._
import akka.actor.ActorSystem
import akka.actor.Props

/*class MyHelloActor extends Actor {
  def receive = {
    case "hello" => println("hello back at you")
    case _ => println("huh?")
  }
}*/
class MyHelloActor(myName: String) extends Actor {
  def receive = {
    case "hello" => println("hello from %s".format(myName))
    case _ => println("'huh?', said %s".format(myName))
  }
}
object Main extends App {
  val system = ActorSystem("HelloSystem")
  //default Actor constructor
  //val helloActor = system.actorOf(Props[MyHelloActor], name = "myhelloactor")
  val helloActor = system.actorOf(Props(new MyHelloActor("Fredie")), name = "myhelloactor")
  helloActor ! "hello"
  helloActor ! "buenos dias"
}

/*class MyHelloActor(myName: String) extends Actor {
  def receive: PartialFunction[Any, Unit] = {
    case "hello" => println("hello from %s".format(myName))
    case _       => println("'huh?', said %s".format(myName))
  }
}

object Main extends App{
  val system = akka.actor.ActorSystem("HelloSystem")
  val helloActor = system.actorOf(akka.actor.Props(new MyHelloActor("Fred")), name = "helloactor")
  helloActor ! "hello"
  helloActor ! "buenos dias"
}*/