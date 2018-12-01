package scala复习

object 数组取值 {
  def main(args: Array[String]): Unit = {
    val arr =Array(1,2,3,4,5,6,7,8)
    // 直接遍历每一个值
    for(i<-arr) print(i+" ")
    // 通过下标遍历
    for(i<- 0 until arr.length) print(arr(i)+" ")

  }
}
