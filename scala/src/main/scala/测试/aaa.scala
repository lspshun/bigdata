package 测试

object aaa {
  def main(args: Array[String]): Unit = {
    var array = Array(1, 2, 3, 4, 5)
    var result = for (temp <- 0 until array.length)
      yield array(temp) * array(temp)
    print(result.toArray.toBuffer)
  }

}
