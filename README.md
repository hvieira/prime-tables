# prime-tables

## Build
Requires java 8 and sbt

`sbt clean assembly`

The resulting jar should be under target/scala-2.12

## Run
To execute the jar run
`java -jar prime-multiplication-table.jar`

This will output a 10x10 grid by default.

To generate a table with a specific number of primes run
`java -jar prime-multiplication-table.jar <number_of_primes>`
