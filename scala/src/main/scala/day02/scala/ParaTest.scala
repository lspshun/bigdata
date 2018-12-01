package day02.scala

object ParaTest {
  def main(args: Array[String]): Unit = {
    // TODO Scala多参数列表以及可变参数
    test(1,2,3)(4,5,6)
  }

  def test(x: Int*)(y: Int*): Unit ={

  }
}
