name := "springerLinkFunctionalTests"

version := "1.0"

scalaVersion := "2.11.8"

testOptions in Test += Tests.Argument("-h", "target/test-reports")

libraryDependencies ++= Seq(
  "org.seleniumhq.selenium" % "selenium-java" % "3.5.3",
  "org.scalatest" % "scalatest_2.11" % "3.0.3" % "test->*"
)
    