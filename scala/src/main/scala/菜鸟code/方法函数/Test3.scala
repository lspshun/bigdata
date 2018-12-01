package 菜鸟code.方法函数

object Test3 {
  // 定义一个方法 m1 参数要求是函数 参数的参数是两个int 类型的 返回值也为int类型
  def m1(f: (Int, Int) => Int): Int = {
    f(2, 6)
  }

  // 定义函数f1
  val f1 = (x: Int, y: Int) => x + y
  val f2 = (m: Int, n: Int) => m * n

  // main
  def main(args: Array[String]): Unit = {

    // 调用m1 并传入f1函数
    val r1 = m1(f1)
    print(r1)

    // 调用m1方法 并且传入f2函数
    val r2 = m1(f2)
    print(r2)

  }

}
