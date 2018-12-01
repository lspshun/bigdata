package day02.scala

import scala.collection.mutable.ArrayBuffer

object ArrayBufferTest {
  def main(args: Array[String]): Unit = {
    // TODO ArrayBuffer练习：单行程序
    val array = Array[Double](1,2,3,4,5)
    val arrayBuffer = new ArrayBuffer[Double]()
    arrayBuffer ++= array
    val temp = (for (i <- 0 until array.length) yield array(i) * array(i).toDouble).toArray
    arrayBuffer ++= temp
    // 使用map函数：传入一个函数，作用在集合每一个元素上，结果构成一个新的集合
    //val result = Array[Double](1,2,3,4,5).map((x:Double) => x * x).toArray
    val result = (new ArrayBuffer[Double]() ++= Array[Double](1,2,3,4,5) ++= Array[Double](1,2,3,4,5).map((x:Double) => x * x).toArray).sorted
    println(result)
  }
}
