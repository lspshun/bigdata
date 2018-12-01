package day03.scala

class Point(xPosition:Int,yPosition:Int){

  private var x:Int = xPosition
  private var y:Int = xPosition

  def move(x:Int,y:Int): Unit ={
    this.x += x
    this.y += y
    println("x轴坐标为：" + this.x)
    println("y轴坐标为：" + this.y)
  }

  // 辅助构造器 -> 必须在首行调用主构造器或者其他的辅助构造器
  /*def this(x:Int){
    this()
    this.x = x
  }*/

  /*def this(x:Int,y:Int){
    this()
    this.x = x
    this.y = y
  }*/

}


object Point{
  // TODO 类的定义和实例化
  def main(args: Array[String]): Unit = {
    // 使用new关键字可以调用主构造器和辅助构造器进行初始化
    val point1 = new Point(0,0)
    point1.move(3,4)
    println(point1.x)
    // 调用时根据参数列表进行匹配，省略new关键字 -> 会调用apply方法
    val point2 = Point(3)
    val point3 = Point(10,20)
    println(point2.x)
    println(point3)

  }

  // 实例化对象时可以使用apply方法，通常用于放回一个实例
  // 对于apply方法的参数列表和返回值类型都可以进行自定义
  def apply(xPosition: Int, yPosition:Int): Point = {
    println("两个参数的apply")
    new Point(xPosition, yPosition)
  }

  def apply(xPosition: Int): Point = {
    println("一个参数的apply")
    new Point(xPosition,0)
  }
}

