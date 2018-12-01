package day02.scala

object TupleTest {
  def main(args: Array[String]): Unit = {
    // TODO 多元组间的拉链操作
    val names = Array("student1","student2","student3")
    val ages = Array(20,22,21)
    val scores = Array(80,88,75)
    val result = names.zip(ages).zip(scores)
    // 如果将元素以元组传入时，需要注意逗号与括号间的关系，防止被识别为多个参数
    val fun:(((String,Int),Int)) => (String,Int,Int) = (temp) => {
      // 将fun传入map函数时，temp代表集合中每次取出的元素
      // 根据集合的嵌套结构取出内部的数据
      (temp._1._1,temp._1._2,temp._2)
    }
    println(result.map(fun).toBuffer)
  }
}
