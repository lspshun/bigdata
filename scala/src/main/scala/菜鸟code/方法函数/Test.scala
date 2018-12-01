package 菜鸟code.方法函数

// scala 有方法函数
// 方法是类的  方法是组成类的一部分
// 函数是一个对象可以赋值给一个变量 在类中定义的方法就是函数
// scala使用val定义函数 使用def语句定义方法
// 有些翻译上 函数funciton 和方法method没有区别
// 没有返回值 定义为unit 类似Java中的void

object Test {
  def main(args: Array[String]): Unit = {
    def addInt(a: Int, b: Int): Int = {
      var sum: Int = 0
      sum = a + b
      return sum
    }
  }


}
