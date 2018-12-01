package 菜鸟code.方法函数

object Test2 {
  def main(args: Array[String]): Unit = {
    val result = addInt(1,2)
    print(result)
  }
  def  addInt(a:Int,b:Int):Int={
  var sum:Int = 0
  sum = a+b
  return sum
  }
}
