name := "scala-training"

version := "0.1"
scalaVersion := "2.13.6"

libraryDependencies += "com.typesafe.play" %% "play-logback" % "2.8.7"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.10"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test"
libraryDependencies += "com.microsoft.playwright" % "playwright" % "1.17.2"
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.9"
scalacOptions ++= Seq("encoding", "utf-8")