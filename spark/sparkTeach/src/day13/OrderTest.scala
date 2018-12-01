package day13

import org.apache.spark.{SparkConf, SparkContext}

case class Person(name: String, age: Int, height: Int)

object MySort{
  implicit val compare = new Ordering[Person]{
    override def compare(x: Person, y: Person): Int = {
      // x：待排元素
      // y：已排好的元素
      // 按照年龄升序 -> 身高降序
      if (x.age != y.age){
        x.age - y.age
      }else{
        - (x.height - y.height)
      }
    }
  }
}

object OrderTest {
  def main(args: Array[String]): Unit = {
    // 0.初始化
    val sparkConf = new SparkConf().setAppName("Master").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    val list = List(("tom",20,173),("jerry",19,167),("jack",21,180),("rose",20,163))
    val listRDD = sc.parallelize(list,1)
    import MySort.compare
    // 默认升序的参数为true -> 会按照指定规则排序
    // 指定为false时 -> 原排序规则的倒序
    listRDD.sortBy(person => Person(person._1,person._2,person._3)).foreach(println)
  }
}
