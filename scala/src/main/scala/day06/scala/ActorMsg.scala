package day06.scala

import scala.actors.{Actor, Future}

// 接收消息的对象类型可以是任意类型
// 异步对象 - 用于匹配客户端发送过来的消息类型
case class AsyncMsg(code: Int, msg: String)
// 同步对象 - 用于匹配客户端发送过来的消息类型
case class SyncMsg(code: Int, msg: String)
// 响应消息 - 传回客户端的消息类型
case class ReplyMsg(code: Int, msg: String){
  // 重写样例类的toString方法
  override def toString: String = {
    s"code: $code, msg: $msg"
  }
}

class ActorService extends Actor{
  override def act(): Unit = {
    // 模拟服务端一直处于开启状态
    while (true){
      // 偏函数 - receive用于标记接收消息的动作
      receive{
        case "start" => {
          println("开始运行。。。")
          Thread.sleep(1000)
          sender ! ReplyMsg(0, "start")
        }
        case AsyncMsg(code,msg) => {
          println(s"code: $code, msg: $msg")
          Thread.sleep(3000)
          sender ! ReplyMsg(-1, "success")
        }
        case SyncMsg(code,msg) => {
          println(s"code: $code, msg: $msg")
          Thread.sleep(3000)
          sender ! ReplyMsg(1, "success")
        }
      }
    }
  }
}

object ActorMsg {

  def main(args: Array[String]): Unit = {
    // TODO Actor实现消息发送
    val actorService = new ActorService
    actorService.start()
    // 在默认情况下返回值类型为Future[Any] -> 通过Apply方法获取的对象类型也为Any
    val reply: Future[ReplyMsg] = (actorService !! "start").asInstanceOf[Future[ReplyMsg]]
    // scala中的Future使用apply方法获得返回值 -> 直接调用会阻塞，等待调用执行的线程完毕后再继续执行，相当于同步
    // println(reply.apply()) // 相当于Java中Future的get
    println(reply.isSet) // 相当于Java中Future的isDone
    Thread.sleep(1100)
    println(reply.apply())
  }

}
