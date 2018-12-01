package scala复习
// to 是一个方法 可以进行参数传递 map把每一个元素取出来进行相应的操作
object 参数传递 {
  def main(args: Array[String]): Unit = {
    print(1.to (10).map(_*10))
    // Vector(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)
  }
}
