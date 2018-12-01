package day01.scala

object MatchTest {
  def main(args: Array[String]): Unit = {
    // TODO Scala模式匹配的初级用法
    // a的初始值为10
    val a = -10
    // 常量的规则：只能被赋值一次
    val B = 1
    // match不会发生穿透 -> 匹配一次之后就会将结果返回 -> 不需要写break语句
    // 每个case中都是一个代码块 -> 最后一行为返回值 -> 可以使用变量接收match表达式的值
    val result = a match{
      // 类似变量匹配的方式
      // 1.var b = 1
      // 2.val b = 1
      // 当case关键字后面出现变量时，会将待匹配的变量的值赋值给case后的变量
      // 3.val B = 1
      // 当case后面出现常量时，正常进行值的判断
      case B => {
        println(B)
      }
      case c if c > 0 => {
        println("这是一个正数")
        500
      }
      // 字面常量匹配
      case 100 => {
        println(100)
      }
      // 使用下划线作为通配，防止无匹配时报错
      case _ => {
        println("无匹配")
      }
    }
    println(result)
  }
}
