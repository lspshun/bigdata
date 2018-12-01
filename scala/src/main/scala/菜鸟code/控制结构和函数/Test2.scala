package 菜鸟code.控制结构和函数

//for循环,计算字符串中所有字母的Unicode代码（toLong方法）的乘积。
// 举例来说，"Hello"中所有字符串的乘积为9415087488L
object Test2 {
  def main(args: Array[String]): Unit = {
    //var t: Long = 1
    product("5")

    // 用for循环解决
    //    for (i <- "hello"){
    //      t=t*i.toLong
    //    }
    //    print(t)

    // 用StringOps 的foreach解决
    //    "hello".foreach(t*=_.toLong)
    //    println(t)
  }

  // 编写函数解决
  def product(s: String): Unit = {
    var t: Long = 1
    for (i <- s) {
      t * i.toLong
    }
    print(t)
  }

  // 改为递归函数
  def product2 (s:String):Long={
    if (s.length ==1)
      return s.charAt(0).toLong
    else
      s.take(1).charAt(0).toLong * product2(s.drop(1))}

}
