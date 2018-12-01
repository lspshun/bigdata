package day05.homework

import scala.io.Source

object Work01 {

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("E://dataflow.log")
    // 每一行的数据作为一个元素存储在lines中
    val lines = source.getLines().toList
    // 如果声明的类型中出现元组，需要多一层括号
    val f:((String,List[Array[String]])) => ((String,Int,Int,Int)) = (content) => {
      val upFlow = content._2
      var upFlowSum = 0
      for(array <- upFlow){
        upFlowSum += array(1).toInt
      }
      (content._1,upFlowSum,content._2.map(_(2).toInt).sum,content._2.map(_(1).toInt).sum + content._2.map(_(2).toInt).sum)
    }
    // 提供字符串转换为字符串数组的功能 -> 对于每一行的数据通过逗号分割，得到每一列的数据
    val step1:(String) => (Array[String]) = (line) => line.split(",")
    // groupBy函数：以谁为参照进行分组
    val result = lines.map(_.split(",")).groupBy(_(0)).map(f)
    println(result)
    /*for(temp <- result){
      println(temp)
    }*/
  }

}
