name := "SbtStarter"

version := "1.0"

scalaVersion := "2.12.1"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.14.0"

javaOptions in reStart += "-Dfile.encoding=utf8"
