import akka.actor.{Actor, ActorSystem, ActorRef, Props}


object MyActor {
	case class Init(aref: ActorRef)
	case class Msg(b: Boolean)
}

class MyActor extends Actor {
	import MyActor._

	def receive: Receive = {
		case Init(aref) =>
			// wysyłamy do aref pierwszą „piłeczkę”
			aref ! Msg(true)
		case Msg(b) =>
			println(s"""$self: ${if (b) "ping" else "póng"}""")
			// wysyłamy do nadawcy komunikat z wartością !b
			sender() ! Msg(!b)
	}

}

object MainAkka {
	import MyActor._

	def main(args: Array[String]): Unit = {
		val sys = ActorSystem("system")
		val a = sys.actorOf(Props[MyActor], "A")
		val b = sys.actorOf(Props[MyActor], "B")
		a ! Init(b)
		// sys.terminate()
	}

}
