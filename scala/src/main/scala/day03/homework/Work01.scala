package day03.homework

import scala.collection.mutable.ListBuffer

object Work01 {
  def main(args: Array[String]): Unit = {
    // TODO flatten方法模拟实现
    val list = List(List(1,2,3),List(4,5,6)) // List(1,2,3,4,5,6)
    println(list.toBuffer)
    println(flatten(list))

  }
  def flatten(list: List[List[Int]]) : ListBuffer[Int] = {
    val result:ListBuffer[Int] = new ListBuffer()
    // 使用嵌套循环遍历每一个元素，放入一个集合中
    for (collection <- list){
      for (content <- collection){
        result += content
      }
    }
    result
  }
}
