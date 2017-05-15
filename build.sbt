name := "dynamodb-scala"

version := "1.0"

scalaVersion := "2.11.7"


libraryDependencies ++= Seq(
  //"io.atlassian.aws-scala" %% "aws-scala-dynamodb"  % "7.0.6",
  "com.amazonaws" % "aws-java-sdk-dynamodb" % "1.10.62",
"com.github.dwhjames" %% "aws-wrap" % "0.8.0"


)
