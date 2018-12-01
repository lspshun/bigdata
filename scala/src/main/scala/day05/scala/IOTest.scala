package day05.scala

import scala.io.Source

object IOTest {
  def main(args: Array[String]): Unit = {
    // TODO 文件读取及URL读取
    val source = Source.fromFile("E://data.txt")
    val lines = source.getLines()
    for (line <- lines)
      println(line)
    println(source.mkString)
    val url = Source.fromURL("http://www.baidu.com");
    println(url.mkString)
    source.close()
  }
}
