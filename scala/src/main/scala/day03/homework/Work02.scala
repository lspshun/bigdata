package day03.homework

object Work02 {
  def main(args: Array[String]): Unit = {
    // TODO 集合-模式匹配
    /*println("请输入数组的长度")
    val n = readInt()
    val array = new Array[Int](n)
    println("请输入数组的元素")
    for (index <- 0 until array.length){
      array(index) = readInt()
    }*/
    val array = Array(1,2,3,4,5)
    array match {
      // case a if a.length == 5 => println("数组长度为5")
      // case Array(1,2,_*) => println("数组以1,2元素开头")
      // case a if a(a.length - 1) == 5 => println("数组以5结尾")
      // case a if a.max > 3 => println("数组的最大值超过3")
      case a if a.sum == 15 => println("数组的和为15")
      case _ => println("没有匹配")
    }
  }
}
