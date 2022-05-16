name := "mxt_finance"
version := "0.1.0"
scalaVersion := "2.13.8"

val catsEffectV = "3.3.11"
val zioVersion = "1.0.14"

libraryDependencies ++= List(
  "dev.zio" %% "zio" % zioVersion,
  "dev.zio" %% "zio-test" % zioVersion % "test",
  "dev.zio" %% "zio-test-sbt" % zioVersion % "test"
)

testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

lazy val root = project in file(".")
