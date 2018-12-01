package test

import org.apache.spark.{SparkConf, SparkContext}

object WordCountDemo {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Master").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val data = sc.textFile("E:/utils和软件安装包/教学环境/数据/data.txt")
    // print(data)
    val result = data.flatMap(_.split(" ")).filter(word => word != " ").map(word => (word,1)).reduceByKey(_ + _)
    println(result.collect.foreach(println))
    result.saveAsTextFile("e://wordresult.txt")
    // result.saveAsTextFile("hdfs://bigdata:8020/output/wordCount")
  }

}
