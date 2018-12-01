package day02.homework

object Work02 {
  def main(args: Array[String]): Unit = {
    // TODO day02作业2
    val set = Set[Int](1,2,3,4,5,6)
    val t = set.splitAt(3)
    t.productIterator.foreach({
      i => {
        val temp = i.asInstanceOf[Set[Int]]
        val it = temp.iterator
        while (it.hasNext){
          println(it.next())
        }
      }
    })
  }
}
