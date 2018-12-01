package day13

import java.net.URL

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

import scala.collection.mutable
import scala.collection.mutable.Map

object Subject {
  def main(args: Array[String]): Unit = {
    // 0.初始化
    val sparkConf = new SparkConf().setAppName("Master").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    // 1.读取数据源
    val access: RDD[String] = sc.textFile("E://access.txt",1)
    // 2.数据维度提取
    val data = access.map(line => {
      val fields = line.split("\t")
      val url = fields(1)
      val subject = new URL(url).getHost
      (subject, url)
    })
    // 统计每个学科被访问的次数
    // val subject = data.groupBy(_._1).mapValues(it => it.toList.size).partitionBy(new HashPartitioner(3))
    // subject.saveAsTextFile("E://subjectResult1")
    // 统计每个URL被访问的次数
    // val url = data.groupBy(_._2).mapValues(it => it.toList.size).partitionBy(new HashPartitioner(3))
    // url.saveAsTextFile("E://urlResult1")
    // data.groupBy(_._1).foreach(println)
    val partitioner = new SubjectPartitioner(data.keys.distinct.collect())
    data.groupBy(_._1).partitionBy(partitioner).saveAsTextFile("E://result")
    sc.stop()
  }
}

class SubjectPartitioner(subjects: Array[String]) extends Partitioner{
  // 总共分区数
  override def numPartitions: Int = subjects.length
  // key和分区的对应关系
  val map:Map[String, Int] = new mutable.HashMap
  // 计数器->标识分区
  var partition = 0
  for (subject <- subjects){
    map.put(subject,partition)
    partition += 1
  }
  // 指定分区规则
  override def getPartition(key: Any): Int = {
    map.getOrElse(key.toString,0)
  }
}