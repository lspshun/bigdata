package day01.scala

object Test02 {

  def main(args: Array[String]): Unit = {
    // TODO Scala实现分数的分级
    // 使用read{Type}从控制台读入
    val score = readInt()
    val level = score match {
      case bad if(bad < 60) => {
        println("不及格")
        "不及格"
      }
      case c if (c >= 60 && c < 69) =>{
        println("C")
        "C"
      }
      case b if (b >= 70 && b < 79) =>{
        println("B")
        "B"
      }
      case a if (a >= 80 && a < 89) =>{
        println("A")
        "A"
      }
      case aa if (aa >= 90 && aa <= 100) =>{
        println("A+")
        "A+"
      }
    }
    println(level)
  }

}
