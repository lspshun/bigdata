package streamingteach.kafka.consumer

import java.util
import java.util.Properties

import org.apache.kafka.clients.consumer.{ConsumerRecord, ConsumerRecords, KafkaConsumer}
import streamingteach.util.PropertiesUtil

object Consumer {
  def main(args: Array[String]): Unit = {
    // 读取配置文件后给消费者指定不同的id
    val prop1:Properties = new PropertiesUtil("kafkaConsumer.properties").getProperties
    prop1.setProperty("group.id","test01")
    val prop2:Properties = new PropertiesUtil("kafkaConsumer.properties").getProperties
    prop2.setProperty("group.id","test02")
    val consumer1 = new KafkaConsumer[Int,String](prop1)
    val consumer2 = new KafkaConsumer[Int,String](prop2)
    // 传入的集合为Collection子类
    consumer1.subscribe(util.Arrays.asList("first_topic"))
    consumer2.subscribe(util.Arrays.asList("first_topic"))
    while (true){
      // 设置超时时间，接收生产数据
      val records1: ConsumerRecords[Int, String] = consumer1.poll(100)
      val records2: ConsumerRecords[Int, String] = consumer2.poll(100)
      val it1 = records1.iterator()
      // 使用迭代器遍历
      while (it1.hasNext){
        val record: ConsumerRecord[Int, String] = it1.next()
        println(s"consumer1 - offset:${record.offset},key:${record.key},value:${record.value}")
      }
      val it2 = records2.iterator()
      // 使用迭代器遍历
      while (it2.hasNext){
        val record: ConsumerRecord[Int, String] = it2.next()
        println(s"consumer2 - offset:${record.offset},key:${record.key},value:${record.value}")
      }
    }
  }
}
