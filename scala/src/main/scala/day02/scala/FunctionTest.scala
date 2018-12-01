package day02.scala

object FunctionTest {
  def main(args: Array[String]): Unit = {
    // TODO 函数的声明和传递 - 四则运算练习
    println("输入第一个数：")
    val x = readInt()
    println("输入运算符号：")
    val sign = readLine()
    println("输入第二个数：")
    val y = readInt()
    val result = method(x,y,sign)
    println(result)
  }

  def method(x: Int,y: Int,z: String): Int ={
    val add:(Int, Int) => Int = (x,y) => x + y
    val sub = (_:Int) - (_:Int)
    val c:(Int,Int) => Int = (_ * _)
    val d = (x:Int,y:Int) => x / y
    // match：模式匹配的表达式可以直接作为返回值
    // 编译校验时，会检查每一个case的返回值是否符合方法的定义
    z match {
      case "+" => add(x,y)
      case "-" => sub(x,y)
      case "*" => getResult(x,y,c)
      case "/" => getResult(x,y,d)
      case _ => {
        println("不支持的运算符")
        -1
      }
    }
  }

  // 方法定义时，函数的参数的声明需要满足待传入函数的参数类型以及返回值类型要求
  def getResult(x:Int,y:Int,f:(Int,Int) => Int): Int ={
    f(x,y)
  }

}
