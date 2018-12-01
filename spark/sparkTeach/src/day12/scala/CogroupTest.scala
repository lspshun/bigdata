package day12.scala

import org.apache.spark.{SparkConf, SparkContext}

object CogroupTest {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("Master").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    // 相当于有两个key，1 -> 1,1 2 -> 2,2,2
    val list1 = List((1,1),(1,1),(2,2),(2,2),(2,2))
    // 相当于有五个key
    val list2 = List((1,1),(2,2),(3,3),(4,4),(5,5))
    val pairRDD1 = sc.parallelize(list1)
    val pairRDD2 = sc.parallelize(list2)
    val cogroupRDD1 = pairRDD1.cogroup(pairRDD2)
    cogroupRDD1.foreach(println)
    val cogroupRDD2 = pairRDD2.cogroup(pairRDD1)
    cogroupRDD2.foreach(println)
    val joinRDD1 = pairRDD1.join(pairRDD2)
    joinRDD1.foreach(println)
    val joinRDD2 = pairRDD2.join(pairRDD1)
    joinRDD2.foreach(println)
  }
}
