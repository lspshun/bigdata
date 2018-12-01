package day07.scala

// 在类后定义的泛型作用域为类中的所有成员
class Test[T,U]{

  // 将具有相同类型约束的参数提取出来做统一限定
  // 在类被使用时可以指定一个或一组泛型
  // 在方法调用时可以再次指定泛型进行限制
  // 在方法后声明的泛型作用域为当前方法
  def method1[T](x:T,y:U) = {x}

  def method2(x:Int,y:Int) = {x}
}

object MethodTest {
  def main(args: Array[String]): Unit = {
    // TODO 方法中的泛型
    val test = new Test[Any,Any]
    test.method1[Int](1,"1")
  }
}
