package day05.homework

import java.util.concurrent.{Callable, Executors, FutureTask}

import scala.collection.mutable
import scala.io.Source

object Work02MR {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("E://dataflow.log")
    val lines = source.getLines().toList
    val task = lines.size / 3
    val future1 = new FutureTask[Map[String,List[Array[String]]]](new Callable[Map[String,List[Array[String]]]] {
      override def call(): Map[String,List[Array[String]]] = {
        val data = lines.splitAt(task)._1
        val result = data.map(_.split(",")).groupBy(_(0))
        result
      }
    })
    val future2 = new FutureTask[Map[String,List[Array[String]]]](new Callable[Map[String,List[Array[String]]]] {
      override def call(): Map[String,List[Array[String]]] = {
        val data = lines.splitAt(task)._2.splitAt(task)._1
        val result = data.map(_.split(",")).groupBy(_(0))
        result
      }
    })
    val future3 = new FutureTask[Map[String,List[Array[String]]]](new Callable[Map[String,List[Array[String]]]] {
      override def call(): Map[String,List[Array[String]]] = {
        val data = lines.splitAt(task * 2)._2
        val result = data.map(_.split(",")).groupBy(_(0))
        result
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
    // 定义一个空的Map集合
    val map:mutable.Map[String,List[Array[String]]] = mutable.Map()
    // 中间结果的合并操作
    for ((k,v) <- result1){
      map(k) = v
    }
    for ((k,v) <- result2){
      if (map.getOrElse(k,Unit) == Unit){
        map(k) = v
      }else{
        map(k) = map(k) ++: v
      }
    }
    for ((k,v) <- result3){
      if (map.getOrElse(k,Unit) == Unit){
        map(k) = v
      }else{
        map(k) = map(k) ++: v
      }
    }
    println(map)
    val f:((String,List[Array[String]])) => ((String,Int,Int,Int)) = (content) => {
      (content._1,content._2.map(_(1).toInt).sum,content._2.map(_(2).toInt).sum,content._2.map(_(1).toInt).sum + content._2.map(_(2).toInt).sum)
    }
    val result = map.map(f)
    println(result)
    cachedThreadPool.shutdown()
  }
}
