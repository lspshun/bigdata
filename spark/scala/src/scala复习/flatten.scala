package scala复习

// TODO:  List的flatten 可以将一个list嵌套list、list嵌套字符串压平
object flatten {

  def main(args: Array[String]): Unit = {
    val ls1=List(1,2,3,4,5,6,7,8,9)
    val ls2=ls1.grouped(5)
    val ls3=ls2.toList
    println(ls3) //List(List(1, 2, 3, 4, 5), List(6, 7, 8, 9))
    println(ls3.flatten)
    //list套list有压平操作  也可以压平 list中套多个字符串的情况
   // 结果：list(1, 2, 3, 4, 5, 6, 7, 8, 9)
  }
}
