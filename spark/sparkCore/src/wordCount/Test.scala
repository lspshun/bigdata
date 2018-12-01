package wordCount

import org.apache.spark.{SparkConf, SparkContext}

object Test {

  def main(args: Array[String]) {
    //创建SparkConf()并设置App名称
    val conf = new SparkConf().setMaster("spark://bigdata:7077").setAppName("Master")
      .set("spark.executor.cores","1")
      .setJars(List("C:\\Users\\Administrator\\Desktop\\Spark\\3.code\\spark\\sparkcore_wordcount\\target\\wordcount-jar-with-dependencies.jar"))
      .setIfMissing("spark.driver.host", "192.168.56.1")

    //创建SparkContext，该对象是提交spark App的入口
    val sc = new SparkContext(conf)
    //使用sc创建RDD并执行相应的transformation和action
    val result = sc.textFile("C:\\Users\\Administrator\\Desktop\\Spark\\3.code\\spark\\spark.log").flatMap(_.split(" ")).map((_, 1)).reduceByKey(_+_, 1).sortBy(_._2, false)
    //停止sc，结束该任务

    result.collect().foreach(println)


    sc.stop()

  }

}
