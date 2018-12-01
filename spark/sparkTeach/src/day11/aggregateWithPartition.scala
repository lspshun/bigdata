package day11

import org.apache.spark.{SparkConf, SparkContext}

object aggregateWithPartition {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Master")
    val sc = new SparkContext(sparkConf)
    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val listRDD = sc.parallelize(list,3)
    val seqop:(String,Int) => (String) = {
      (zero,value) => {
        val result = (zero.split(",")(0).toInt * value) + "," + (zero.split(",")(1).toInt + value)
        result
      }
    }
    val combop:(String,String) => (String) = {
      (par1,par2) => {
        // 记录每个分区中的数据
        if ("1,0".equals(par1)){
          par2 + "|"
        }else if("1,0".equals(par2)){
          par1 + "|"
        }else{
          par1 + "|" + par2 + "|"
        }
      }
    }
    val result = listRDD.aggregate("1,0")(seqop,combop)
    println(result)
    for (r <- result.split("\\|").filter(_ != "")){
      println(r)
    }
  }
}
