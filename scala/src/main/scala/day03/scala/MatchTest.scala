package day03.scala

object MatchTest {

  def main(args: Array[String]): Unit = {
    // TODO 集合的模式匹配
    val list = List(1,2,3)
    // 使用常量进行匹配时同样需要使用大写
    val LIST1 = List(1,2,3,4)
    list match {
      //case LIST1 => println("匹配成功")
      // 下划线可以代表任意类型的单个元素
      case List(_,_,3) => println("匹配成功")
      // 单独出现时将待匹配元素看做一个整体，依然可以匹配
      case _ => println("没有匹配")
    }
    val a:Int = 5
    a match {
      // 使用下划线和冒号构建出和变量定义相同的结构
      case _:Int => println("匹配到整型")
    }
    val array = Array(1,2,3,4)
    array match {
      // 可以使用自定义的变量获取到集合对象，进行自定义的逻辑判断
      case a if a(a.length - 1) == 4 => println("数组以4结尾")
      // 使用_*可以代表任意的元素，只能出现在最后，通常用于匹配固定开头的集合
      case Array(1,2,_*) => println("数组以1开头")
    }
    list match {
      // 将集合拆分为一个::运算符的形式 -> 执行顺序为从右至左
      case x :: y :: z => {
        println(x)
        println(y)
        println(z)
        println("集合中包含三个元素")
      }
      case List(1,2,3) => println("List方式匹配1,2,3")
      case 1 :: List(2,3) => println("::拼接集合匹配到1,2,3")
    }
  }

}
