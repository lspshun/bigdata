package day02.homework

object Work01 {
  def main(args: Array[String]): Unit = {
    // TODO day02作业1
    val x = readInt()
    val y = readInt()
    val factor = readInt()
    val multi:(Int) => (Int) = (x) => x * factor
    val result = mix(x,y,add _,multi)
    println(result)
  }

  def add(x: Int,y: Int): Int ={
    x + y
  }

  def mix(x: Int,y: Int,f1: (Int, Int) => (Int),f2: (Int) => (Int)): Int ={
    f2(f1(x,y))
  }
}
