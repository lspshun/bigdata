package day06.scala

// 类[泛型] -> 定义了一个compare -> 调用compareTo -> 来自于实现了Comparable接口的类
// 将T转换为一个实现Comparable接口的类
// T -> T <: Comparable[T]
// 参数列表中定义了一个隐式声明的函数 -> 搜索当前作用域中是否有相应的函数
// 在Predef中搜索，或用户自定义的隐式函数
class PairTest[T]{
  def compare(first:T,second:T)(implicit f: T => Comparable[T]): Unit ={
    // 参数列表中的T类型已经被隐式转换为T <: Comparable[T]
    first.compareTo(second)
  }
}

class Test{

}

class Test1 extends Comparable[Test]{
  override def compareTo(o: Test): Int = {
    0
  }
}

object ConvertTest {

  implicit val f:(Test) => Test1  = (x) => {
    println("我被执行")
    // 模拟类型转换的过程
    x.asInstanceOf[Test1]
  }

  def main(args: Array[String]): Unit = {
    // TODO 视图界定-隐式函数查找
    val pair = new PairTest[Test]
    pair.compare(new Test,new Test)
  }
}
