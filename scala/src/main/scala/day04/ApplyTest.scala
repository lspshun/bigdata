package day04

// 在类名后声明主构造器() -> new的方式调用
class ApplyTest(xP:Int){

  // Scala中定义的成员变量必须有初始值
  var x:Int = xP
  var y:Int = 0
  // 在变量前使用private声明时，变量以及相应的封装方法都会变为私有的
  // 在变量前不使用private声明时，变量是私有的，自动提供公有的封装方法
  // 通过对象调用属性成员时，调用的封装方法
  // 只能在伴生对象中与类共享私有的成员(使用private修饰的成员)

  // Java中会有一个默认的构造器，可以显示声明空的构造方法 -> 没有自定义的构造器时会添加空的构造器

  // 辅助构造器使用def this(参数列表)
  // 不建议显示声明空的构造器
  /*def this(){
    // 在首行调用其他辅助构造器和主构造器
    this()
    // 其他代码
  }*/

  /*def this(x:Int){
    // 在Scala中空的构造器出现在自定义的构造器的首行
    this()
    this.x = x
  }*/

}

object ApplyTest {
  // TODO 类的实例化方式 - 构造器/apply
  def apply(xP: Int): ApplyTest = {
    new ApplyTest(xP)
  }

  def apply(xP: Int,yP:Int): ApplyTest = {
    val a = new ApplyTest(xP)
    a.y = yP
    a
  }

  def main(args: Array[String]): Unit = {
    // 1.构造器实例化
    val applyTest1 = new ApplyTest(1)
    applyTest1.y = 2
    // 2.apply
    // 使用阶段根据需要动态的去初始化成员变量
    // 类名(参数列表) -> 当前的object中定义的apply方法会被调用
    val applyTest2 = ApplyTest(1)
    val applyTest3 = ApplyTest(1,2)
    method(applyTest3)
    println(applyTest3.x)
  }

  // 需求：将当前对象的所有信息传递，不传递整个引用
  def method(applyTest:ApplyTest): Unit ={
    println(applyTest.x)
    println(applyTest.y)
    applyTest.x = 10
  }
}
