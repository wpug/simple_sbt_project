name := "SbtStarter"

version := "1.0"

scalaVersion := "2.11.8"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val nsclaTimeV = "2.14.0"
  val akkaV = "2.4.11"
  Seq(
      "com.github.nscala-time" %% "nscala-time" % "2.14.0",
      "com.typesafe.akka" %% "akka-actor" % "2.4.11"
  )
}

javaOptions in reStart += "-Dfile.encoding=utf8"
