package week6

object maps {
  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
  capitalOfCountry("US")
  capitalOfCountry get "Andorra"
  capitalOfCountry get "US"

  def showCapital(country: String) = capitalOfCountry.get(country) match {
    case Some(capital) => capital
    case None          => "missing data"
  }

  showCapital("US")

  capitalOfCountry map (x => x)
  for {
    (x, y) <- capitalOfCountry
  } yield x

  val fruit = List("apple", "pear", "orange", "pineapple")
  fruit sortWith (_.length < _.length)
  fruit.sorted

  fruit groupBy (_.head)

  val a = List((1, 2), (2, 3))
  val b = (2, 2)

  (for {
    (exp, coeff) <- a
    if (b._1) == exp
  } yield (exp, b._2 + coeff)).head

  val cap1 = capitalOfCountry withDefaultValue "<unknown>"
  cap1("Andorra")

  val m = Map("a" -> 1, "b" -> 2)

  val incM = m map { case (key, value) => (key, value + 1) }
  // capitalOfCountry("Andorra")

  val test = Map('a' -> 1, 'b' -> 2, 'a' -> 3)
}