package hvieira.primes

import scala.util.{Success, Try}

object PrimeMultiplicationTable extends App {


  def generatePrimeMultiplicationTable(numOfPrimes: Int): List[List[String]] = {

    def multiplyByAllOtherPrimes(aPrime: Int, primes: List[Int]): List[String] = {
      " " + aPrime.toString :: primes.map(anotherPrime => aPrime * anotherPrime).map(el => " " + el.toString)
    }

    val primeList = PrimeSieve.getPrimes(numOfPrimes)

    val startingAccumulator: List[List[String]] = List(List("  ") ++ primeList.map(p => " " + p.toString()))

    primeList.foldLeft(startingAccumulator)((acc, prime) => acc :+ multiplyByAllOtherPrimes(prime, primeList))
  }

  def printablePrimeMultiplicationTable(numberOfPrimes: Int): List[String] = {
    generatePrimeMultiplicationTable(numberOfPrimes).map(el => el.mkString("|", "|", "|"))
  }

  def printPrimeMultiplicationTable(numberOfPrimes: Int): Unit = {
    println(printablePrimeMultiplicationTable(numberOfPrimes).mkString("\n"))
  }

  private def printUsage() = {
    println("Prints a prime multiplication table")
    println("java -jar prime-multiplication-table.jar <number_of_primes>")
    println("Default is having a 10x10 table")
    System.exit(1)
  }

  args.toList match {
    case firstArg :: List() => {
      Try(Integer.parseInt(firstArg)) match {
        case Success(value) => printPrimeMultiplicationTable(value)
        case _ => printUsage()
      }
    }
    case List() => printPrimeMultiplicationTable(10)
    case _ => printUsage()
  }

}
