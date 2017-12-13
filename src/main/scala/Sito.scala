import akka.actor.{Actor, ActorSystem, ActorRef, Props}

case class Init(n: Int)
case class Num(n: Int)
case object GetResult
case class Result(r: List[Int])

class Boss extends Actor {
  val a = context.actorOf(Props[Worker], "Glowny")

  def receive: Receive = {
    case Init(n) =>
      for (i <- 2 to n) {
        a ! Num(i)
      }
      a ! GetResult
      context.become(zLiczbą(n))
    }

  def zLiczbą(n: Int): Receive = {
    case Result(r) =>
      // println(s"Wynik to: $r")
      val długość = r.length
      val największa = r.last
      println(s"Liczba liczb pierwszych od 2 do $n  wynosi $długość")
      println(s"Największa z nich to $największa")
      context.system.terminate()
  }
}

class Worker extends Actor {
  def receive: Receive = {
    case Num(n) =>
      context.become(zLiczbą(n))
  }

  def zLiczbą(n: Int): Receive = {
    case Num(k) =>
      if (k % n != 0) {
        val a = context.actorOf(Props[Worker])         // tworzymy potomka
        a ! Num(k)        // wysyłamy do niego Num(k)
        context.become(zLiczbąOrazPotomkiem(n,a))      // stajemy się zLiczbąOrazPotomkiem
      }
    case GetResult =>
      sender ! Result(List(n))
  }

  def zLiczbąOrazPotomkiem(n: Int, a: ActorRef): Receive = {
    case Num(k) =>
      if (k % n != 0) {
        a ! Num(k)        // wysyłamy do niego Num(k)
      }
    case Result(l) =>
      context.parent ! Result(n :: l)
    case GetResult =>
      a ! GetResult
    case msg =>
  }
}

object Er extends App {
  val system = ActorSystem("Pierwsze")
  val boss = system.actorOf(Props[Boss], "Boss")
  boss ! Init(222222)
}
