package day01.scala

object YieldTest {
  def main(args: Array[String]): Unit = {
    // TODO 使用yield生成新的集合
    val array = Array(1,3,5,7,9)
    val result = for(temp <- 0 until array.length)
      yield array(temp) * array(temp)
    println(result.toArray.toBuffer)
  }
}
