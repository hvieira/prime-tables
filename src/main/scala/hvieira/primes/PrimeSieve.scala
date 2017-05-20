package hvieira.primes

object PrimeSieve {

  private val sieveRange = 10000

  val beginOfSieve = (1 to sieveRange).toVector.map(num => (num, true))
  val primes = computeSieve(beginOfSieve, 2)
    .filter(t => t._1 != 1)
    .filter(t => t._2)
    .map(t => t._1)

  private def computeSieve(sieve: Vector[(Int, Boolean)], currentPrime: Int): List[(Int, Boolean)] = {

    def markMultiplesAsNonPrime(sieve: Vector[(Int, Boolean)], multiples: List[Int]): Vector[(Int, Boolean)] = {
      multiples match {
        case multiple :: tail => markMultiplesAsNonPrime(sieve.updated(multiple - 1, (multiple, false)), tail)
        case List() => sieve
      }
    }

    val updatedSieve = markMultiplesAsNonPrime(sieve, findMultiples(currentPrime))

    val nextPrime = sieve.find(tuple => (tuple._1 <= sieveRange && tuple._1 > currentPrime && tuple._2))
    nextPrime match {
      case Some(prime) => computeSieve(updatedSieve, prime._1)
      case None => sieve.toList
    }

  }

  private def findMultiples(number: Int): List[Int] = {

    def inner(multiples: List[Int], number: Int, multiplier: Int): List[Int] = {
      val calculatedMultiple = number * multiplier
      if (calculatedMultiple > sieveRange)
        multiples
      else
        inner(multiples :+ calculatedMultiple, number, multiplier + 1)
    }

    inner(List(), number, 2)
  }

  def getPrimes(numberOfPrimes: Int): List[Int] = {
    if (numberOfPrimes < 0)
      throw new IllegalArgumentException("Cannot generate primes until a negative number")
    else
      primes.slice(0, numberOfPrimes)
  }

}
