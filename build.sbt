// *****************************************************************************
// Projects
// *****************************************************************************

lazy val ci =
  project
    .in(file("."))
    .enablePlugins(GitVersioning, GitBranchPrompt)
    .settings(settings)
    .settings(
      libraryDependencies ++= Seq(
        library.redisClient,
        library.configLib,
        library.scalaCheck % Test,
        library.scalaTest  % Test
      )
    )

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val library =
  new {
    val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.13.5"
    val scalaTest  = "org.scalatest"  %% "scalatest"  % "3.0.3"
    val redisClient = "net.debasishg" %% "redisclient" % "3.4"
    val configLib = "com.typesafe" % "config" % "1.3.1"
  }

// *****************************************************************************
// Settings
// *****************************************************************************

lazy val settings =
  commonSettings ++
  gitSettings ++
  scalafmtSettings

lazy val commonSettings =
  Seq(
    scalaVersion := "2.12.3",
    organization := "nl.jaspertimmer",
    organizationName := "Jasper Timmer",
    startYear := Some(2017),
    scalacOptions ++= Seq(
      "-unchecked",
      "-deprecation",
      "-language:_",
      "-target:jvm-1.8",
      "-encoding", "UTF-8"
    ),
    unmanagedSourceDirectories.in(Compile) := Seq(scalaSource.in(Compile).value),
    unmanagedSourceDirectories.in(Test) := Seq(scalaSource.in(Test).value)
)

lazy val gitSettings =
  Seq(
    git.useGitDescribe := true
  )

lazy val scalafmtSettings =
  Seq(
    scalafmtOnCompile := true,
    scalafmtOnCompile.in(Sbt) := false,
    scalafmtVersion := "1.1.0"
  )
