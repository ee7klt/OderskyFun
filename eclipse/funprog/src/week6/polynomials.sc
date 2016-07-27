package week6

object polynomials {
  class Poly(terms0: Map[Int, Double]) {
    // this auxiliary constructor allows us to pass multiple (arbitrary number)
    // of arguments to new Poly.
    // this allows us to remove the intermediate 'Map' data structure in the declaration
  	def this(bindings: (Int, Double)*) = this(bindings.toMap)
  	
    // default values allows us to just add in adjust without checking if exponent exists.
    // shortens by removing for-expression in adjust
    
    val terms = terms0 withDefaultValue 0.0
   // def +(other: Poly) = new Poly(terms ++ (other.terms map adjust))
   
    // alternative implementation of  + using foldLeft instead of
    // concatenation ++
    def + (other: Poly) =
    	new Poly((other.terms foldLeft terms)(addTerm))
    	
    def addTerm(terms: Map[Int,Double], term: (Int,Double)): Map[Int,Double] = {
    		val (exp, coeff) = term
    	  terms map {
    	  	case (exp1, coeff1) =>
    	  		if (exp1 == exp) (exp, (coeff + coeff1))
    	  		else (exp1, coeff1)
    	  		}
    }
    
    //adjust: used for + operation with concatenation ++
    def adjust(term: (Int, Double)): (Int, Double) = {
      val (exp, coeff) = term
      exp -> (terms(exp) + coeff)
    }

		// print results out nicely
    override def toString = {
      val lines =
        for {
          (exp, coeff) <- terms.toList.sorted.reverse
        } yield coeff + "x^" + exp
      lines mkString " + "
    }
  }

  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2) //> p1  : week6.polynomials.Poly = 6.2x^5 + 4.0x^3 + 2.0x^1
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0)           //> p2  : week6.polynomials.Poly = 7.0x^3 + 3.0x^0
  p1 + p2                                         //> res0: week6.polynomials.Poly = 6.2x^5 + 11.0x^3 + 2.0x^1
  p1.terms(7)                                     //> res1: Double = 0.0

}