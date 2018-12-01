package day04

object PartialTest {

  def main(args: Array[String]): Unit = {
    // TODO 偏函数
    // 使用时与正常方法的调用相同
    println(partial("123"))
    // 判断所需要的key是否存在于case的中(作用域中)
    println(partial.isDefinedAt("1"))
  }

  // 与方法定义的区别：将参数类型和返回值类型一同在PartialFunction中声明，不需要定义形参
  def partial:PartialFunction[String,Int] = {
    case "123" => 456
  }
}
