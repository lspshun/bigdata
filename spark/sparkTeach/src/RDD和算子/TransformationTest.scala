package RDD和算子

import org.apache.spark.{SparkConf, SparkContext}
object TransformationTest {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("Master").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    // TODO:  转换算子 返回一个新的RDD 新的RDD由原来的RDD每个元素经过function准换后组成
    val list = List(1,2,3,4,5)
    val listRDD = sc.parallelize(list) //创建RDD
    println(listRDD.count)  //元素个数
    listRDD.foreach(println) // 迭代遍历
    val mapConvert = listRDD.map(_ * 2) //转变
    println(mapConvert.count)
    mapConvert.foreach(println)
    Thread.sleep(50000000) // 设置等待时间 在控制台查看信息
  }
}
