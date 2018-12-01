package RDD和算子

import java.io.{File, FileInputStream, ObjectInputStream}

object GetData {
  def main(args: Array[String]): Unit = {
    val fileInput = new FileInputStream(new File("E:/rdd_0_1"))
    val input = new ObjectInputStream(fileInput);
    val data = input.readObject().asInstanceOf[Int];
    println(data)
  }
}
