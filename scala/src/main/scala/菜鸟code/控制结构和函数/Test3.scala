package 菜鸟code.控制结构和函数
// 编写函数计算计算,其中n是整数，使用如下的递归定义:
// 不得使用return语句
object Test3 {

  def main(args: Array[String]): Unit = {
    print(mi(2,3))

  }
  def mi(x:Double,n:Int):Double={

    if(n == 0) 1
    else if(n>0) x * mi(x,n-1)
    else 1/mi(x,-n)
  }
}
