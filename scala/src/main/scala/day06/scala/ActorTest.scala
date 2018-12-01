package day06.scala

import scala.actors.Actor

class Actor1 extends Actor{
  override def act(): Unit = {
    for (i <- 1 to 10){
      println(s"actor1:$i")
    }
  }
}

class Actor2 extends Actor{
  override def act(): Unit = {
    for (i <- 1 to 10){
      println(s"actor2:$i")
    }
  }
}

object ActorTest {

  def main(args: Array[String]): Unit = {
    // TODO Scala中使用Actor实现并发
    val actor1 = new Actor1
    val actor2 = new Actor2
    actor1.start()
    actor2.start()
  }

}
