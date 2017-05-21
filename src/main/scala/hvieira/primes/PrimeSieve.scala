package hvieira.primes

object PrimeSieve {

  private val sieveRange = 300000

  private def computePrimes(): List[Int] = {

    def inner(primes: List[Int], currentNum: Int): List[Int] = {

      if (currentNum > sieveRange)
        primes
      else {
        // reduce search space
        val possibleDivisors = primes.takeWhile(prime => Math.pow(prime, 2) <= currentNum)

        // if is prime
        if (possibleDivisors.forall(d => currentNum % d != 0))
          inner(primes :+ currentNum, currentNum + 1)
        else
          inner(primes, currentNum + 1)
      }

    }

    inner(List(2), 3)
  }

  val primes = computePrimes()

  def getPrimes(numberOfPrimes: Int): List[Int] = {
    if (numberOfPrimes < 0)
      throw new IllegalArgumentException("Cannot generate primes until a negative number")
    else
      primes.slice(0, numberOfPrimes)
  }

}
