package day04

case class Test01(x:Int,y:Int){

}

object Test01 {

  def main(args: Array[String]): Unit = {
    // TODO 样例类
    val test01 = new Test01(1,2)
    val test02 = new Test01(1,2)
    val test03 = Test01(3,4)
    val test04 = Test01(3,4)
    val test05 = Test01(5,6)
    println(test01 == test02)
    println(test03 == test04)
    println(test03 == test05)
  }

}
