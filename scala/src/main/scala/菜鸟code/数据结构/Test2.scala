package 菜鸟code.数据结构
// 编写一个循环，将整数数组中相邻的元素置换。
// 比如Array(1, 2, 3, 4, 5)置换后为Array(2, 1, 4, 3, 5)
object Test2 {
  def main(args: Array[String]): Unit = {
    def revert(arr: Array[Int]) = {
      for (i <- 0 until(arr.length - 1, 2)) {
        val t = arr(i)
        arr(i) = arr(i + 1)
        arr(i + 1) = t
      }

    }

    val a = Array(1, 2, 3, 4, 5)
    revert(a)
    a.foreach(println)
  }

}
