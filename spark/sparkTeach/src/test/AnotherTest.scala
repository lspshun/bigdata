package test
import org.apache.spark.{SparkContext, SparkConf}
object AnotherTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("test").setMaster("local[4]")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(List(1,2,3))
    println(rdd1.reduce(_+_))
    Thread.sleep(500000)
  }
}