package day06.scala

import scala.actors.Actor

class ActorReceive extends Actor{
  override def act(): Unit = {
    while (true){
      receive{
        case "start" => {
          println("receive: "+Thread.currentThread())
          sender ! "reply"
        }
      }
    }
  }
}

class ActorReact extends Actor{
  override def act(): Unit = {
    loop{
      react{
        case "start" => {
          Thread.sleep(500)
          println("react: "+Thread.currentThread())
          sender ! "reply"
        }
      }
    }

  }
}

object ActorPool {
  def main(args: Array[String]): Unit = {
    // TODO Actor的线程复用
    // 使用cached线程池的方式
    /*for (_ <- 1 to 15){
      new ActorReceive().start() !? "start"
    }*/
    for (_ <- 1 to 15){
      // 同步时复用率更高
      new ActorReact().start() !? "start"
    }
  }
}
