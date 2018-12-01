package day03.scala

object FunctionTest {
  def main(args: Array[String]): Unit = {
    // TODO filter及map方法
    val list:List[Int] = List(0,1,2,3,4,5)
    // 函数的参数为集合中的元素类型，返回值类型为布尔类型
    val f:(Int) => Boolean = (x) => {
      // 取出偶数
      x % 2 == 0
    }
    val result1 = list.filter(f)
    println(result1.toBuffer)
    val mapFunc:(Int) => Double = (x) => {
      x.toDouble
    }
    val result2 = list.map(mapFunc)
    println(list.map(_ * 2).toBuffer)

  }
}
