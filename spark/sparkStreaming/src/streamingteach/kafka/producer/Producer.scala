package streamingteach.kafka.producer

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import streamingteach.util.PropertiesUtil

object Producer {
  def main(args: Array[String]): Unit = {
    val props = new PropertiesUtil("kafkaProducer.properties").getProperties
    val producer = new KafkaProducer[Int,String](props)
    for (i <- 0 until 100)
      producer.send(new ProducerRecord("first_topic",i,s"value:$i"))
    producer.close()
  }
}
