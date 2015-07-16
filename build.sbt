name := "scala-serializers-sandbox"

organization := "com.kostassoid"

version := "1.0"

scalaVersion := "2.11.7"

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

libraryDependencies += "io.spray" %%  "spray-json" % "1.3.2"

libraryDependencies += "org.scala-lang.modules" %% "scala-pickling" % "0.10.1"

libraryDependencies += "io.github.netvl.picopickle" %% "picopickle-core" % "0.2.0"

libraryDependencies += "io.github.netvl.picopickle" %% "picopickle-backend-jawn" % "0.2.0"

libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.2.11"
    