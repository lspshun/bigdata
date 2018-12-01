package day03.scala

trait Logger {
  def write(message: String)
}

// 在类的定义时直接引入特征
class UserLogger extends Logger{
  override def write(message: String): Unit = {
    println(s"已将日志信息:${message}记录")
  }
}

class ConsoleLogger{

}

object Test{
  def main(args: Array[String]): Unit = {
    // TODO 特征的使用
    val userLog = new UserLogger
    userLog.write("开始记录")
    // 可以在获得类的实例时动态混入特征(trait)
    val consoleLog = new ConsoleLogger with Logger{
      // 如果重写的抽象方法，可以省略override关键字
      override def write(message: String): Unit = {
        println(s"已将日志信息:${message}记录")
      }
    }
    consoleLog.write("控制台打印")
  }
}