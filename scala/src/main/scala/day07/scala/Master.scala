package day07.scala

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

class Master extends Actor{

  override def preStart(): Unit = {
    println("服务已启动")
  }

  override def receive: Receive = {
    case "test" => println("接收到服务端测试消息")
    // 给客户端进行回应
    case "connect" => {
      println("客户端连入会话")
      sender ! "reply"
    }
  }
}

object Master{
  def main(args: Array[String]): Unit = {
    // TODO Akka-服务端
    val host = "localhost"
    val port = "6666"
    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
         |akka.remote.netty.tcp.port = "$port"
       """.stripMargin
    // 解析字符串，加载配置项
    val conf = ConfigFactory.parseString(configStr)
    // 开启一个服务，监听对应ip的端口，相当于Actor总管理器
    val actorSystem = ActorSystem("Master",conf)
    // 创建一个actor，准备用于通信
    val master = actorSystem.actorOf(Props[Master],"master")
    // 给自己发送消息
    master ! "test"

  }
}