package scala复习

object flatMap_wordCount {
  def main(args: Array[String]): Unit = {
    val lines = List("hello tom hello jerry", "hello tom hello kitty hello china")
    // 拿到每一个元素 按照空格拆分  flatMap=map+flatten
    // print(lines.map(_.split(" ")).flatten)
    val words = lines.flatMap(_.split(" "))
    //List(hello, tom, hello, jerry, hello, tom, hello, kitty, hello, china)

    // 将单词出现一次放入元祖
    val wordsAddOne=words.map((_,1))
    // ((hello,1), (tom,1), (hello,1), (jerry,1), (hello,1), (tom,1), (hello,1), (kitty,1), (hello,1),
    // print(wordsAddOne)

    // groupBy 按照单词分组返回map
    // 第一个_表示list中每一个元祖,取元祖中某一个元素._n  返回的是一个map
    val grouped = wordsAddOne.groupBy(_._1)
//     println(grouped)
    // Map(kitty -> List((kitty,1)), china -> List((china,1)), tom -> List((tom,1), (tom,1)), hello -> List((

    // 求和 t就是个对偶元组 仍然返回一个map
    val result = grouped.map(t=>(t._1,t._2.size))
//    print(result)
    // 直接对第一个单词和list.size  scala没有这种操作
    // val result=grouped.map(_._1,_._2.size)

    // 按照出现次数大小进行排序
    val finalResult = result.toList.sortBy(_._2).reverse
    print(finalResult)




  }

}
