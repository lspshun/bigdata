package day13

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Mobile {
  def main(args: Array[String]): Unit = {
    // 0.初始化
    val sparkConf = new SparkConf().setAppName("Master").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    // 1.读取数据源
    val base: RDD[String] = sc.textFile("E://data/jizhan/base_info.txt",1)
    val user: RDD[String] = sc.textFile("E://data/jizhan/log",1)
    // 2.数据清洗 - 维度提取
    val f1:String => ((String, Long, String)) = line => {
      val fields = line.split(",") // 逗号分隔，读取每一行的数据
      val phone = fields(0) // 手机号
      var time = fields(1).toLong // 时间点
      val base = fields(2) // 基站ID
      val event = fields(3).toInt // 事件类型
      // 将进入时间标记为-，使得整个的计算规则均为加
      if (event == 1) time *= -1
      (phone, time, base)
    }
    val userData = user.map(f1)
    val baseData = base.map(line => {
      val fields = line.split(",") // 逗号分隔，读取每一行的数据
      val base = fields(0) // baseId
      val x = fields(1) // x
      val y = fields(2) // y
      (base, (x, y))
    })
    // 3.数据结构构建
    val f2:((String, Long, String)) => ((String, String), Long) = (content) => {
      ((content._1,content._3),content._2)
    }
    // 4.分组计算每个用户在每个基站中的停留时长
    val phoneBaseWithTime: RDD[((String, String), Long)] = userData.map(f2).reduceByKey(_ + _)
    // 5.按停留时间排序，取出停留时间最长的两组数据
    // sc.parallelize 不能出现在函数里面
    val phoneWithList: RDD[(String, List[((String, String), Long)])] = phoneBaseWithTime.groupBy(_._1._1).mapValues(it => {
      it.toList.sortWith(_._2 > _._2).take(2).toList
    })
    // 重新进行数据整理，将基站ID放置在最前，准备join
    val phoneWithList1: RDD[(String, List[(String, (String, Long))])] = phoneWithList.mapValues(content => {
      content.map(value => {
        (value._1._2, (value._1._1, value._2))
      })
    })
    // 6.输出结果
    val result = phoneWithList1.flatMap(_._2).join(baseData)
    result.map(_._2).foreach(println)
    sc.stop()
  }
}
