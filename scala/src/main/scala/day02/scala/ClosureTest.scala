package day02.scala

object ClosureTest {

  def main(args: Array[String]): Unit = {

    // 闭包：将外部变量与函数体构成完整的表达式(映射关系)
    var factor = readInt() // 声明变量后，会有相应的初始值
    val mu = (x:Int) => x * factor
    println(mu(5))
    // 在外部修改和函数体相关的变量时，函数会发生改变(映射关系)
    factor = 20
    println(mu(5))
  }

}
