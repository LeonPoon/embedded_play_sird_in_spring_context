name := "embedded_play_sird_in_spring_context"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies += "com.typesafe.play" %% "play-akka-http-server" % "2.7.9"
libraryDependencies += "org.springframework" % "spring-context" % "4.3.9.RELEASE"
libraryDependencies += "javax.annotation" % "javax.annotation-api" % "1.3.2"
libraryDependencies += "com.google.inject" % "guice" % "4.2.3"
libraryDependencies += "org.springframework.guice" % "spring-guice" % "1.1.4.RELEASE"
libraryDependencies += "com.typesafe.play" %% "play-guice" % "2.7.9"
libraryDependencies += "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.14.1"
libraryDependencies += "com.typesafe.play" %% "filters-helpers" % "2.7.9"
