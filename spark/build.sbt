name := "spark"

version := "0.1"

scalaVersion := "2.10.7"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.3" % "provided"

libraryDependencies += "org.scala-lang" % "scala-actors" % "2.10.7"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.14"

libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.3.14"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.46"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.6.3"

libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.10.2.2"
