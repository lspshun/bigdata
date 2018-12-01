package day11.work

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Work03 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Master")
    val sc = new SparkContext(sparkConf)
    val list = List((1,1),(1,3),(1,5),(1,7),(2,2),(2,4),(2,6),(2,8))
    val pairRDD: RDD[(Int,Int)] = sc.parallelize(list)
    pairRDD.groupByKey().foreach(println)
    val seq1: (Int,Int) => (Int) = (zero,value) => {
      zero * value
    }
    val com1: (Int,Int) => (Int) = (par,otherPar) => {
      par * otherPar
    }
    pairRDD.aggregateByKey(1)(seq1,com1).foreach(println)
    val seq2: (Int,Int) => (Int) = (zero,value) => {
      zero + value
    }
    val com2: (Int,Int) => (Int) = (par,otherPar) => {
      par + otherPar
    }
    pairRDD.aggregateByKey(0)(seq2,com2).foreach(println)
  }
}
