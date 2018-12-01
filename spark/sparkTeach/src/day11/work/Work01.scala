package day11.work

import org.apache.spark.rdd.RDD
import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

object Work01 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Master")
    val sc = new SparkContext(sparkConf)
    val list = List("张三:20","李四:21","王五:20")
    val listRDD: RDD[String] = sc.parallelize(list,3)
    val f : (Iterator[String]) => (Iterator[(String,Int)]) = it => {
      var result:ListBuffer[(String,Int)] = ListBuffer()
      while (it.hasNext){
        val value = it.next()
        val name = value.split(":")(0)
        val age = value.split(":")(1).toInt
        result.append((name,age))
      }
      result.iterator
    }
    println(listRDD.mapPartitions(f).partitions.size)
    // 重新分区 - 传入分区器(分区数量)
    println(listRDD.mapPartitions(f).partitionBy(new HashPartitioner(1)).partitions.size)
  }
}
