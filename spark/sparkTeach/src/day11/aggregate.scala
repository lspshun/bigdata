package day11

import org.apache.spark.{SparkConf, SparkContext}

object aggregate {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Master")
    val sc = new SparkContext(sparkConf)
    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val listRDD = sc.parallelize(list,1)
    val seqop:((Int,Int),(Int)) => (Int,Int) = {
      (zero,value) => {
        println(zero)
        (zero._1 * value,zero._2 + value)
      }
    }
    val combop:((Int,Int),(Int,Int)) => ((Int,Int)) = {
      (par1,par2) => {
        // 记录每个分区中的数据
        // println("执行")
        (par1._1 + par2._1,par1._2 + par2._2)
    }
    }
    println(listRDD.aggregate((1,0))(seqop,combop))
  }
}
