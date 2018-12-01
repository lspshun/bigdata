package RDD和算子

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Mobile {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("master")
    val sc = new SparkContext(sparkConf)
    val base: RDD[String] = sc.textFile("e://bse_info.txt")
    val user: RDD[String] = sc.textFile("e://log")
    val f: String => ((String, Long, String, Int)) = line => {
      val fileds = line.split(",")
      val phone = fileds(0)
      val time = fileds(1).toLong
      val base = fileds(2)
      val event = fileds(3) toInt

      (phone, time, base, event)
    }
    user.map(f) foreach (println)
  }

}
