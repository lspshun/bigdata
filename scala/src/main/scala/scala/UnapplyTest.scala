package scala

class Test2{
  var x1:Int = 0
  var x2:Int = 0
}

class UnapplyTest(xP:Int,yP:Int){
  var x:Int = xP
  var y:Int = yP
}

object UnapplyTest {
  // TODO 提取器 - 对象间的比较
  // apply方法在用于实体类的实例化时，通常直接返回对象或者构建一个字符串或集合记录所有成员的信息
  def apply(x: Int,y: Int): String = {
    s"x=$x,y=$y"
  }

  // unapply的参数列表为apply方法返回的类型，返回值类型由用户需要取出的变量决定
  def unapply(value: String): Option[(Int,Int)] = {
    println("方法被调用")
    Some(value.split(",")(0).split("=")(1).toInt,value.split(",")(1).split("=")(1).toInt)
  }

  // 当比较两个对象是否相同，通常通过比较成员属性是否完全一致
  def main(args: Array[String]): Unit = {
    val Test1 = UnapplyTest(1,2)
    val Test2 = UnapplyTest(1,2)
    val Test3 = UnapplyTest(3,4)
    val t1 = new UnapplyTest(1,2)
    val T2 = new UnapplyTest(1,2)

    println(Test1 == Test2)
    println(Test1 == Test3)
    println(t1 == T2)
    /*println(test1)
    println("x:" + unapply(test1).get._1 + ",y:" + unapply(test1).get._2)*/

    // 通过apply可以实现== match两种方式比较对象是否相同 -> 转换为成员属性值的比较
    Test1 match {
      case Test2 => println("两个对象相等")
      case _ => println("没有匹配")
    }

    // 当进行自定义的对象的实例的比较时，使用unapply方法进行队形属性的提取，进行对象之间的比较
    Test1 match {
      case UnapplyTest(content) => println(content)
      case _ => println("没有匹配")
    }

    // x:1,y:2 => 当前对象的x属性是否为1
    t1 match {
      case test if(test.x == 1 && test.y == 2) => println("x的属性值为1")
    }

    // 对于相同结构的实体可以使用同样代码 => 使用泛型以及方法的封装可以实现工具类
    Test1 match {
      case UnapplyTest(content) if (content._1 == 1 && content._2 == 2) => println("实体的属性值与指定值相同")
      case _ => println("没有匹配")
    }

  }
}
