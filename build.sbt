import Dependencies._

ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "com.example"
ThisBuild / version      := "0.1.0"

lazy val hello = (project in file("."))
  .aggregate(helloCore)
  .dependsOn(helloCore)
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "Hello",
    libraryDependencies += scalaTest % Test,
  )

lazy val helloCore = (project in file("core"))
  .settings(
    name := "Hello Core",
    libraryDependencies ++= Seq(gigahorse, playJson),
    libraryDependencies += scalaTest % Test,
  )

lazy val dsls = (project in file("dsls"))
  .settings(
    name := "DSLs"
  )

lazy val playground = (project in file("playground"))
  .settings(
    name := "Scala Playground",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += scalastic,
  )