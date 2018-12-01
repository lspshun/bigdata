package day07.scala

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}

class Worker extends Actor{

  override def preStart(): Unit = {
    println("会话已启动")
    // 指定需要请求的服务地址及目标actor，通过/user/{userName}确定建立通信的actor
    val master: ActorSelection = context.actorSelection("akka.tcp://Master@localhost:6666/user/master")
    master ! "connect"
  }

  // 接收行为：偏函数
  override def receive: Receive = {
    case "test" => println("接收到客户端测试消息")
    case "reply" => {
      println("接收到Master发送的信息")
    }
  }
}

object Worker{
  def main(args: Array[String]): Unit = {
    // TODO Akka-客户端
    val host = "localhost"
    val port = "8888"
    // 配置项字符串
    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
         |akka.remote.netty.tcp.port = "$port"
      """.stripMargin
    // 解析字符串
    val config: Config = ConfigFactory.parseString(configStr)
    // 开启一个服务，监听对应ip的端口，相当于Actor总管理器
    val actorSystem = ActorSystem("Worker",config)
    // 创建一个actor，准备用于通信
    val worker = actorSystem.actorOf(Props[Worker],"worker")
    // 给自己发送消息
    worker ! "test"
  }
}