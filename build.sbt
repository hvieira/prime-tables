name := "prime-multiplication-table"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++=  Seq (
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

mainClass := Some("hvieira.primes.PrimeMultiplicationTable")