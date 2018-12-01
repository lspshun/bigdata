package RDD和算子

// TODO: aggregate函数将分区里的元素与初始值进行聚合，然后执行combine操作，将每个分区的结果再进行聚合，最终返回的结果不需要和原RDD类型一致
import org.apache.spark.{SparkConf, SparkContext}
// 这个函数是柯里化的方法
object aggregate {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Master")
    val sc = new SparkContext(sparkConf)
    val list = List(1, 2, 3, 4, 5, 6)
    // 通过已有集合的结构创建RDD
    val listRDD = sc.parallelize(list,3)
    val seqop:((Int,Int),(Int)) => (Int,Int) = {
      (zero,value) => {
        //println(zero)
        (zero._1 * value,zero._2 + value)  //各元素相乘 初始值为1  各元素相加 初始值为2
      }
    }
    val combop:((Int,Int),(Int,Int)) => ((Int,Int)) = {
      (par1,par2) => {
        // 记录每个分区中的数据
        (par1._1 + par2._1,par1._2 + par2._2)
    }
    }
    // 初始值是1,0
    println(listRDD.aggregate((1,0))(seqop,combop))
  }
}
