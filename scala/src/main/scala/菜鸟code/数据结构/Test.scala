package 菜鸟code.数据结构
// 将a设置为一个n个随机整数的数组，要求随机数介于0和n之间。
object Test {
  def main(args: Array[String]): Unit = {

    def makeArr(n:Int):Array[Int]={
      val a= new Array[Int](n)
      val rand = new scala.util.Random()
      for(i<- a) yield rand.nextInt(n)
    }
    makeArr(5).foreach(println)
  }
}
