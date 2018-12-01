package day13

import org.apache.spark.{SparkConf, SparkContext}

object AccumulatorTest {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("Master").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    val list = List(1,2,3,4,5,6)
    val listRDD = sc.parallelize(list, 3)
    // 实现变量的共享，必须由SparkContext创建
    val accumulator = sc.accumulator(0)
    // 不能使用普通变量进行记录
    var sum = 0
    listRDD.foreach(x => {
      accumulator += x
    })
    println(accumulator)
  }
}
