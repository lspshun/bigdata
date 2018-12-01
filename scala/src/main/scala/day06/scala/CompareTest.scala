package day06.scala

// 只要是实现了Comparable接口的类型
// 可以传入某一个范围内的类型
// Predef中定义了基本数据类型到包装类的转换
class Pair[T <% Comparable[T]]{
// <%代表视图界定 -> 会尝试搜索能够满足当前泛型约束的类型，并自动转换

  def compare(first:T,second:T): Unit ={
    println(first.compareTo(second));
  }
}

// 当没有在类中定义接收主构造器参数的成员，而直接在方法中使用，需要显式的将住构造器中的变量使用val/var声明
class Student(val name:String,val age:Int) extends Comparable[Student]{
  override def compareTo(o: Student): Int = {
    this.age - o.age
  }
}

object CompareTest {
  def main(args: Array[String]): Unit = {
    // TODO 视图界定
    val student1 = new Student("s1",20)
    val student2 = new Student("s2",18)
    // 强约束 -> 传入的参数必须是限定的Student类型
    student1.compareTo(student2)
    // 自定义一个比较器 -> 两个对象之间的比较
    val pair1 = new Pair[Student]
    val pair2 = new Pair[Int]// 传入的是Int类型，实际需要Integer
    pair1.compare(student1,student2)
    pair2.compare(1,2)

  }
}
