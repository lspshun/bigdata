package day13

import java.sql.DriverManager

import org.apache.spark.rdd.JdbcRDD
import org.apache.spark.{SparkConf, SparkContext}

object JdbcRDDTest {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("JdbcRDD").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    val jdbcUrl = "jdbc:mysql://localhost:3306/w01?useUnicode=true&characterEncoding=utf8"
    val user = "root"
    val password = "root"
    val conn = () => {
      Class.forName("com.mysql.jdbc.Driver").newInstance()
      DriverManager.getConnection(jdbcUrl, user, password)
    }
    val sql = "select * from make where id between ? and ?"
    val jdbcRDD: JdbcRDD[(Int, String)] = new JdbcRDD(sc, conn, sql, 0, 300, 3,
      res => {
        val id = res.getInt("id")
        val makeName = res.getString("makeName")
        (id, makeName)
      }
    )
    println(jdbcRDD.collect().toBuffer)
    sc.stop()
  }
}
