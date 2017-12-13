name := "SbtStarter"

version := "1.0"

scalaVersion := "2.12.4"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.8",
  "com.github.nscala-time" %% "nscala-time" % "2.18.0"
)

javaOptions in reStart += "-Dfile.encoding=utf8"
