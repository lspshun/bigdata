package day12.scala

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Mobile {
  def main(args: Array[String]): Unit = {
    // 0.初始化
    val sparkConf = new SparkConf().setAppName("Master").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    // 1.读取数据源
    val base: RDD[String] = sc.textFile("E:/data/jizhan/base_info.txt")
    val user: RDD[String] = sc.textFile("E:/data/jizhan/log")
    // 2.数据清洗 - 维度提取
    val f:String => ((String, Long, String, Int)) = line => {
      val fields = line.split(",") // 逗号分隔，读取每一行的数据
      val phone = fields(0) // 手机号
      val time = fields(1).toLong // 时间点
      val base = fields(2) // 基站ID
      val event = fields(3).toInt // 时间类型
      (phone, time, base, event)
    }
    user.map(f).foreach(println)
  }
}
