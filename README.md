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

## Implementation history
Started out with a sieve with a fixed upper bound and computed primes up until that limit.
Issue was that even for a very small amount of primes computation of all possible primes (of the sieve's capacity) would still happen

Changed implementation to use lazy scala streams for much better performance and only the necessary computation

## Aspects to be proud of
- Good prime sieve performance with scala streams
- TDD
- Solution based on single responsibility principle (sieve separate from multiplication table)
- Solution built upon small incremental improvements

## Additional possible improvements
- Test coverage is not extensive. Property based tests may be a better alternative
- Print of multiplication table is not very pretty
- CLI usage could potentially be improved