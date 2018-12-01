package day02.scala

object ArrayTest {
  def main(args: Array[String]): Unit = {
    // TODO 可变集合-不可变集合
    // 可变：在原集合的基础上进行修改
    // 不可变：提供了部分修改集合的方法，不会修改原集合，会返回一个新的集合
    val array = Array(1,3,5,7,9)
    // 使用toBuffer方法转换成一个ArrayBuffer的集合类型，重写了toString方法，输出内部的所有元素，也可以直接作为数组使用
    println(array.toBuffer)

  }
}
