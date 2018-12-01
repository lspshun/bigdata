package day11.work

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

object Work02 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Master")
    val sc = new SparkContext(sparkConf)
    val list = List(1,2,3,4,5,6,7,8,9)
    val listRDD: RDD[Int] = sc.parallelize(list,3)
    val f: (Int,Iterator[Int]) => (Iterator[(Int,Int)]) = (index,it) => {
      var sum = 0
      var result:ListBuffer[(Int,Int)] = ListBuffer()
      while (it.hasNext){
        val value = it.next()
        sum += (value * value)
        result.append((index,value))
      }
      result.append((index,sum))
      result.iterator
    }
    listRDD.mapPartitionsWithIndex(f).groupByKey().foreach(println)

  }
}
