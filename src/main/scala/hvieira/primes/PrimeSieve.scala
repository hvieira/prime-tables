package hvieira.primes

object PrimeSieve {

  private val primes: Stream[Int] =
  // seed a stream with 2 as an already computed prime and then start from 3 lazily
    2 #:: Stream.from(3)
      // get primes until their square is greater than the candidate number -> reduces search space
      // for all those primes verify that the candidate does not have any of them as divisor
      .filter(candidate => primes.takeWhile(prime => Math.pow(prime, 2) <= candidate).forall(prime => candidate % prime > 0))

  def getPrimes(numberOfPrimes: Int): List[Int] = {
    if (numberOfPrimes < 0)
      throw new IllegalArgumentException("Cannot generate primes until a negative number")
    else
      primes.take(numberOfPrimes).toList
  }

}
