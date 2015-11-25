package week2

object rationals {
  val x = new Rational(1,2)
  x.numer
  x.denom
  
  
  /** addition, using class Rational as pure datatype */
  def addRational(r: Rational, s: Rational): Rational =
      new Rational(
          r.numer*s.denom+s.numer*r.denom,
          r.denom*s.denom)
  def makeString(r:Rational) =
      r.numer + "/" + r.denom
      
  val y = new Rational(2,3)
 makeString( addRational(x,y)  )
}


class Rational(x: Int, y: Int) {
	def numer = x
	def denom = y
	
	def add(that: Rational) =
		new Rational(
			
	
	
}