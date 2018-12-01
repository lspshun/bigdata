package test

import org.apache.spark.{SparkConf, SparkContext}

object demo {
  def main(args: Array[String]): Unit = {
    val wordFile = "E://a.txt"
    val conf = new SparkConf().setAppName("wordcount");
    val sc = new SparkContext(conf)
    val input = sc.textFile(wordFile, 2).cache()
    val lines = input.flatMap(line=>line.split(" "))
    val count = lines.map(word => (word,1)).reduceByKey{case (x,y)=>x+y}
    val output = count.saveAsTextFile("/home/hadoop/hellospark")
  }
}
