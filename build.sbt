name := """server"""
version := "2.0"
organization := "com.gitpitch"

lazy val root = (project in file(".")).enablePlugins(PlayJava, LauncherJarPlugin)

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  cache,
  javaWs,
  filters
)

libraryDependencies ++= Seq(
  "com.typesafe.netty" % "netty-reactive-streams-http" % "1.0.6",
  "com.google.guava" % "guava" % "19.0",
  "com.google.inject.extensions" % "guice-assistedinject" % "4.0",
  "org.yaml" % "snakeyaml" % "1.17",
  "commons-io" % "commons-io" % "2.5"
)

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

initialize := {
  val _ = initialize.value
  val javaVersion = sys.props("java.specification.version")
  if (javaVersion != "1.8")
    sys.error("Java 1.8 is required for this project. Found " + javaVersion + " instead")
}
