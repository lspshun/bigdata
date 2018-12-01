package 菜鸟code.数据结构

import scala.collection.mutable.ArrayBuffer

//给定一个整数数组，产出一个新的数组，
//包含原数组中的所有正值，以原有顺序排列，之后的元素是所有零或负值，
//以原有顺序排列
object Test3 {
  def main(args: Array[String]): Unit = {

  }
  def sigNum(array: Array[Int])={
    val buf=new ArrayBuffer[Int]()
    buf ++=(for(i<- array if i>0 )yield  i)
    buf ++=(for(i<- array if i==0 )yield  i)
    buf ++=(for(i<- array if i<0 )yield  i)
    buf.toArray

  }

}
