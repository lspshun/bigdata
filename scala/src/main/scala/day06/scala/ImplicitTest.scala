package day06.scala

import scala.collection.mutable;

object ImplicitTest {

  /*implicit def xxx(array: Array[Int]):Int = {
    array.sum / array.length
  }*/

  implicit class StringExtends(s:String){
    val list:mutable.ListBuffer[Int] = mutable.ListBuffer()

    def find(s: String, findStr: String, index: Int): Unit = { // 返回从起始位置开始查找，第一次出现该字符的位置
      val temp = s.indexOf(findStr, index)
      if (temp == -1) { // 返回-1代表查找结束
      }
      else {
        list.append(temp)
        find(s, findStr, temp + 1)
      }
    }
    def getIndexs(findStr: String): mutable.ListBuffer[Int] ={
      find(s,findStr,0)
      list
    }
  }



  implicit class ArrayExtends(array: Array[Int]){
    def avg : Int = {
      array.sum / array.length
    }
  }

  def main(args: Array[String]): Unit = {
    // TODO 隐式类练习-数组平均值/字符串中查找字符
    val array:Array[Int] = Array(1,2,3,4,5)
    val avg:Int = array.avg
    println(avg)
    val list:mutable.ListBuffer[Int] = "123w647w9492w039w".getIndexs("w")
    for(index <- list){
      println(index)
    }
  }

}
