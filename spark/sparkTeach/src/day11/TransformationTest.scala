package day11

import org.apache.spark.{SparkConf, SparkContext}

object TransformationTest {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("Master").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    val list = List(1,2,3,4,5,6,7,8,9)
    val listRDD = sc.parallelize(list)
    println(listRDD.count)
    listRDD.foreach(println)
    val mapConvert = listRDD.map(_ * 2)
    println(mapConvert.count)
    mapConvert.foreach(println)
    Thread.sleep(50000000)
  }
}
