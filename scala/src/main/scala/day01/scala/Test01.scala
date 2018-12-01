package day01.scala

object Test01 {

  def main(args: Array[String]): Unit = {
    // TODO Scala的if选择结构
    // method 完整的if - else -> 必须保证if/else代码块结尾是相应的数据类型
    // println(method1())
    println(method2())
    // 省略返回值类型，保证程序通过编译(选择结构) - 返回值类型为Unit
    // 利用Scala的动态类型的推断，能够放回不同的数据类型 - 返回值类型声明为Any
  }

  def method2():Any = {
    var a = 5
    if (a != 5){
      var d = 5.0
      d
    }
  }

  def method1():Int = {
    var a = 5
    if (a == 5){
      println(50)
      a
    }else{
      var b = 20
      println(b)
      b
    }
  }

}
