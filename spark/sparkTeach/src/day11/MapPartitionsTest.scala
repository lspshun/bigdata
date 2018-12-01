package day11

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

object MapPartitionsTest {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("Master").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    val list = List(1,2,3,4,5,6,7,8,9)
    val listRDD = sc.parallelize(list,3)
    listRDD.foreach(println)
    val f:Iterator[Int] => Iterator[(Int,Int)] = (it) => {
      // 构建返回结果的集合
      val result:ListBuffer[(Int,Int)] = ListBuffer[(Int,Int)]()
      // 判断下一个元素是否达到末尾 -> 判断后继当中的信息是否为空
      while (it.hasNext){
        // 将游标向后移动一位，取出当前指向的元素
        val value = it.next()
        result.append((value,value * value))
      }
      // 获取集合中的迭代器
      result.iterator
    }
    listRDD.mapPartitions(f).foreach({
      println
    })
  }
}
