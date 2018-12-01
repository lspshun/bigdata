package day01.scala

object MethodTest {

  def main(args: Array[String]): Unit = {
    // TODO Scala的方法定义和参数传递
    // 在参数传递时，可以使用形参的名称指定参数的值，并且与顺序无关
    // 如果不使用参数列表中形参的名称，则按照顺序匹配的规则
    //add(1)
    // 如果参数列表中的参数存在初始值，调用时可以不传递参数
    // 如果带有初始值的参数出现在中间的位置，则调用时无法通过顺序匹配的方式自动获得，需要手动指定
    add(x = 1,z = 2)
    add(1,2,3)
    // 对于多参数列表的方法，如果某一个参数列表中的变量都具有初始值，在进行方法调用时，使用()占位 -> 正在调用方法
    method(1,2)()
  }

  // 求两个整数的和 -> 参数列表中有两个参数 返回值类型为整数类型
  def add(x: Int,y: Int = 10,z: Int): Int ={
    println(x)
    println(y)
    println(z)
    x + y + z
  }

  def method(x:Int,y:Int)(z:Int = 3): Int ={
    x + y + z
  }

}
