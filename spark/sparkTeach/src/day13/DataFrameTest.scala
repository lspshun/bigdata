package day13

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

object DataFrameTest {
  def main(args: Array[String]): Unit = {
    // 0.初始化
    val sparkConf = new SparkConf().setAppName("SparkSQL").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    // 1.构建SqlContext
    val sqlContext = new SQLContext(sc)
    val data: RDD[String] = sc.textFile("E://make.txt")
    // 2.构建所需的Row结构
    val dataRDD: RDD[Row] = data.map(line => {
      val id = line.split(",")(0).toInt
      val makeName = line.split(",")(1)
      // 无泛型约束
      Row(id, makeName)
    })
    val schema = StructType(
      // 使用集合形式构建每一列的结构信息
      List(StructField("id",IntegerType),StructField("makeName",StringType))
    )
    // 使用RDD构建DataFrame
    val dataFrame = sqlContext.createDataFrame(dataRDD, schema)
    // 打印元信息
    dataFrame.printSchema()
    // dataFrame.show()
    // 注册为临时表
    dataFrame.registerTempTable("make")
    // 使用SQL操作查询文本数据
    sqlContext.sql("select * from make where id < 10").show()
  }
}
