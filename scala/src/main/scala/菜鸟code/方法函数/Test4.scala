package 菜鸟code.方法函数

// scala 中无法直接操作方法 操作时需要先将其转换成函数 两种方法转换
// val f1 = m _
// 在方法名称后加一个空格 和下划线 将方法m转换成函数
// val f1: (Int) => Int = m
// 通常情况下 编译器自动将方法转换成函数  在应该传入函数的地方传入了方法

object Test4 {
  def ttt(f: Int => Int) = {
    var r = f(10)
  }

  val f0 = (x: Int) => x * x

  //定义一个方法
  def m0(x: Int): Int = {
    //传递进来的参数乘以10
    x * 10
  }

  //将方法转换成函数，利用了神奇的下滑线
  val f1 = m0 _

  def main(args: Array[String]): Unit = {
    ttt(f0)

    //通过m0 _将方法转化成函数
    ttt(m0 _);

    //如果直接传递的是方法名称，scala相当于是把方法转成了函数
    ttt(m0)

    //通过x => m0(x)的方式将方法转化成函数,这个函数是一个匿名函数，等价：(x:Int) => m0(x)
    ttt(x => m0(x))
  }
}