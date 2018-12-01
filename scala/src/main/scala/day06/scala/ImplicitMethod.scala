package day06.scala

import scala.io.{BufferedSource, Source}

object ImplicitMethod {

  implicit def xxx(x:Double):Int = x.toInt

  implicit class SourceExtend(source : BufferedSource){
    def getString:String = {
      source.mkString
    }
    def getList:List[String] = {
      source.getLines().toList
    }
    def getLine(number : Int):String = {
      source.getLines().toList(number - 1)
    }
  }

  def main(args: Array[String]): Unit = {
    // TODO 隐式方法和隐式类
    // 在编译阶段就会自动寻找可以实现的类型转换
    val x:Int = 6.0
    // 从文件中读取 -> 返回文件中的内容
    // 调用无参的隐式类中的方法使用正常的方法调用格式,否则需要在结尾添加分号，标记结束
    val lines:List[String] = Source.fromFile("E://data.txt").getList
    // 调用有参的隐式类中的方法时，可以使用空格隔开，传入参数
    val firstLine:String = Source.fromFile("E://data.txt") getLine 1
    // val content:String = Source.fromFile("E://data.txt")
    // val lines:List[String] = Source.fromFile("E://data.txt")
    println(lines)
    println(firstLine)
  }

}
