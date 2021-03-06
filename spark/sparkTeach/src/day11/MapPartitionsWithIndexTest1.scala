package day11

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

object MapPartitionsWithIndexTest1 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("Master").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    val list = List(1,2,3,4,5,6,7,8,9)
    val listRDD = sc.parallelize(list,3)
    listRDD.foreach(println)
    val f:(Int, Iterator[Int]) => Iterator[(Int,Int)] = (index, it) => {
      println(index)
      // 构建返回结果的集合
      val result:ListBuffer[(Int,Int)] = ListBuffer[(Int,Int)]()
      if (index == 0){
        while (it.hasNext){
          val value = it.next()
          result.append((index,value * 2))
        }
      }else if(index == 1){
        while (it.hasNext){
          val value = it.next()
          result.append((index,value * 3))
        }
      }else{
        while (it.hasNext){
          val value = it.next()
          result.append((index,value * 4))
        }
      }
      // 获取集合中的迭代器
      result.iterator
    }
    listRDD.mapPartitionsWithIndex(f).foreach({
      println
    })
  }
}
