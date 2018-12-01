package day05.homework

import java.util.concurrent.{Callable, Executors, FutureTask}

import scala.io.Source

object Work02 {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("E://dataflow.log")
    val lines = source.getLines().toList
    val f:((String,List[Array[String]])) => ((String,Int,Int,Int)) = (content) => {
      (content._1,content._2.map(_(1).toInt).sum,content._2.map(_(2).toInt).sum,content._2.map(_(1).toInt).sum + content._2.map(_(2).toInt).sum)
    }
    val task = lines.size / 3
    val future1 = new FutureTask[List[(String,Int,Int,Int)]](new Callable[List[(String,Int,Int,Int)]] {
      override def call(): List[(String,Int,Int,Int)] = {
        val data = lines.splitAt(task)._1
        val result = data.map(_.split(",")).groupBy(_(0)).map(f)
        result.toList
      }
    })
    val future2 = new FutureTask[List[(String,Int,Int,Int)]](new Callable[List[(String,Int,Int,Int)]] {
      override def call(): List[(String,Int,Int,Int)] = {
        val data = lines.splitAt(task)._2.splitAt(task)._1
        val result = data.map(_.split(",")).groupBy(_(0)).map(f)
        result.toList
      }
    })
    val future3 = new FutureTask[List[(String,Int,Int,Int)]](new Callable[List[(String,Int,Int,Int)]] {
      override def call(): List[(String,Int,Int,Int)] = {
        val data = lines.splitAt(task * 2)._2
        val result = data.map(_.split(",")).groupBy(_(0)).map(f)
        result.toList
      }
    })
    val cachedThreadPool = Executors.newCachedThreadPool
    cachedThreadPool.submit(future1)
    cachedThreadPool.submit(future2)
    cachedThreadPool.submit(future3)
    println(future1.get())
    println(future2.get())
    println(future3.get())
    val result1 = future1.get()
    val result2 = future2.get()
    val result3 = future3.get()
    // 将三个集合合并
    val result = result1 ++: result2 ++: result3
    val c:((String,List[(String,Int,Int,Int)])) => ((String,Int,Int,Int)) = (content) => {
      (content._1,content._2.map(_._2).sum,content._2.map(_._3).sum,content._2.map(_._4).sum)
    }
    println(result.groupBy(_._1).map(c))
    cachedThreadPool.shutdown()
  }
}
