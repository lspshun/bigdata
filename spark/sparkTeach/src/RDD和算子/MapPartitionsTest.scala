package RDD和算子
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

// TODO: mapPartitions(function):返回一个新的RDD，将传入的函数作用在每个分片上，传入函数的签名为Iterator[T] => Iterator[U]
object MapPartitionsTest {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setAppName("Master").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    val list = List(1,2,3,4,5,6,7,8,9)
    val listRDD = sc.parallelize(list,3) //设置分区数
    listRDD.foreach(println) //原集合
    val f:Iterator[Int] => Iterator[(Int,Int)] = (iterator) => {
      // 构建返回结果的集合
      val result:ListBuffer[(Int,Int)] = ListBuffer[(Int,Int)]()  // 可变 存在缓冲区的buffer集合
      // 判断下一个元素是否达到末尾 -> 判断后继当中的信息是否为空
      while (iterator.hasNext){
        // 将游标向后移动一位，取出当前指向的元素
        val value = iterator.next()
        result.append((value,value * value)) // 向集合内追加元素
      }
      result.iterator   // 获取集合中的迭代器
    }
    listRDD.mapPartitions(f).foreach({println})
  }
}
