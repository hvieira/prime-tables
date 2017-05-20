package hvieira.primes

import org.scalatest.{Matchers, WordSpec}

class PrimeSieveSpec extends WordSpec with Matchers {

  "Prime Sieve" when {

    "calculating one prime number" should {

      "return 2 in a singleton collection" in {
        PrimeSieve.getPrimes(1) should contain(2)
      }

    }

    "calculating multiple prime numbers" should {

      "compute primes correctly and return in ascending order" in {
        PrimeSieve.getPrimes(11) should contain inOrderOnly(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31)
      }

    }

    "calculating zero prime numbers" should {

      "return empty collection" in {
        PrimeSieve.getPrimes(0) shouldBe empty
      }

    }

    "provided a negative number" should {

      "throw exception" in {
        intercept[IllegalArgumentException] {
          PrimeSieve.getPrimes(-1)
        }
      }

    }

  }

}
