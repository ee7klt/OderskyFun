package week6

object polynomials {
  class Poly(val terms: Map[Int, Double]) {
  	def + (other: Poly) = ???
  	override def toString = {
  		val lines =
  		for {
  			(exp,coeff) <- terms
  		} yield exp + ":" + coeff
  		lines mkString ", "
  	}
  }
  
  
  val p1 = new Poly(Map(1 -> 2.0, 3-> 4.0, 5 -> 6.2))
                                                  //> p1  : week6.polynomials.Poly = 1:2.0, 3:4.0, 5:6.2
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))      //> p2  : week6.polynomials.Poly = 0:3.0, 3:7.0
}