package day03.scala

import scala.collection.mutable

object MapTest {
  def main(args: Array[String]): Unit = {
    // TODO map函数实现练习
    val map:mutable.Map[String,Int] = mutable.Map(("s1",20),("s2",22))
    println(keys(map))
    println(values(map))
  }

  /**
    * keys方法实现：遍历集合，返回key的集合
    * @param map 待遍历集合
    * @return 键的集合
    */
  def keys(map: mutable.Map[String,Int]) : mutable.Buffer[String] = {
    var result = for(temp <- map)
      yield temp._1 // yield生成Vector集合
    result.toBuffer
    result = map.map((temp) => {
      temp._1
    })
    result.toBuffer
  }

  /**
    * values方法实现：遍历集合，返回value的集合
    * @param map 待遍历集合
    * @return 值的集合
    */
  def values(map: mutable.Map[String,Int]) : mutable.Buffer[Int] = {
    var result = for((key,value) <- map)
      yield value
    result.toBuffer
    result = map.map((temp) => {
      temp._2
    })
    result.toBuffer
  }
}
