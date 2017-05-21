package hvieira.primes

object PrimeSieve {

  private val sieveRange = 100000

  val finalSieve = computeSieve()

  private def computeSieve(): List[Int] = {

    def inner(sieve: Vector[Int], currentPrimeIndex: Int): Vector[Int] = {

      if (currentPrimeIndex >= sieve.size)
        sieve
      else {
        val prime = sieve(currentPrimeIndex)
        val multiples = findMultiplesOfPrime(prime)
        inner(sieve.filter(n => !multiples.contains(n)), currentPrimeIndex + 1)
      }
    }

    inner((2 to sieveRange).toVector, 0).toList
  }

  private def findMultiplesOfPrime(prime: Int): Set[Int] = {
    val squareOfPrime = Math.pow(prime, 2).toInt
    (squareOfPrime to sieveRange by prime).toSet
  }

  def getPrimes(numberOfPrimes: Int): List[Int] = {
    if (numberOfPrimes < 0)
      throw new IllegalArgumentException("Cannot generate primes until a negative number")
    else
      finalSieve.slice(0, numberOfPrimes)
  }

}
