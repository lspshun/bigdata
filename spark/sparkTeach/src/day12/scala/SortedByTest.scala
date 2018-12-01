package day12.scala

import org.apache.spark.{SparkConf, SparkContext}

object SortedByTest {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("Master").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    val words = List(("good",1),("good",1),("study",1),("day",1),("day",1),("up",1))
    val pairRDD = sc.parallelize(words)
    // 实现了排序接口的数据类型直接排序
    pairRDD.groupByKey().sortByKey().foreach(println)
  }
}
