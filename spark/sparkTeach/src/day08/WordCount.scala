package day08

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Master").setMaster("yarn-client")
    val sc = new SparkContext(conf)
    val data = sc.textFile("hdfs://SZ01:8020/input/data.txt")
    val result = data.flatMap(_.split(" ")).filter(word => word != " ").map(word => (word,1)).reduceByKey(_ + _)
    println(result.collect.foreach(println))
    result.saveAsTextFile("hdfs://SZ01:8020/output/wordCount")
  }

}
