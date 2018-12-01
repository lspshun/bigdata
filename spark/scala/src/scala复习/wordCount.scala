package scala复习

import scala.io.Source

object wordCount {
  def main(args: Array[String]): Unit = {
    // TODO Scala实现单个程序的WordCount
    val source = Source.fromFile("E://a.txt");
    val lines = source.getLines().toList;
    /*val result:mutable.HashMap[String,Int] = new mutable.HashMap[String,Int]()
    for (line <- lines){
      for(word <- line.split(" ")){
        if (result.getOrElse(word,0) == 0){
          result(word) = 1
        }else{
          result(word) += 1
        }
      }
    }
    for ((k,v) <- result){
      println(s"$k : $v")
    }*/
    // map->作用在每一个元素上
    // flatMap=Map+flatten
    val temp = lines.flatMap(line => line.split(" ").map(word => (word,1))).groupBy(_._1).map(temp => (temp._1,temp._2.size))
    val sum0 = lines.flatMap(line => line.split(" ").map(word => (word,1))).groupBy(_._1).map(temp => (temp._1,{
      var sum = 0
      for (count <- temp._2){
        sum += count._2
      }
      sum
    }))
    val sum1 = lines.flatMap(line => line.split(" ").map(word => (word,1))).groupBy(_._1).map(temp => (temp._1,temp._2.map(value => value._2).reduceLeft(_ + _)))
    // lines.flatMap(line => line.split(" ") => 获取到每个单词
    // lines.flatMap(line => line.split(" ").map(word => (word,1))) => (单词,1),(单词,1)构成的集合
    // lines.flatMap(line => line.split(" ").map(word => (word,1))).groupBy(_._1)
    // (单词,List(元组 -> (单词,1)))构成的映射
    // lines.flatMap(line => line.split(" ").map(word => (word,1))).groupBy(_._1).map(temp => (temp._1,temp._2.size))
    // 最终结果 -> (单词,计数)构成的映射
    // temp._2为单词分组后对应的List列表 -> 取出内部的值进行计算 -> temp._2.map(value => value._2).reduceLeft(_ + _)：提取出内部的计数部分进行累加
    // mapValues -> 迭代过程：获取到的是每个key(单词)对应的集合(List((元组),(元组)))
    val sum2 = lines.flatMap(line => line.split(" ").map(word => (word,1))).groupBy(_._1).mapValues(temp => temp.map(word => word._2).reduceLeft(_ + _))
    println(sum0)
  }
}
