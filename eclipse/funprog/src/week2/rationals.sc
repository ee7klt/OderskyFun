package week2

object rationals {
  val x = new Rational(1,2)                       //> x  : week2#31.Rational#896892 = week2.Rational@51521cc1
  x.numer                                         //> res0: Int#1111 = 1
  x.denom                                         //> res1: Int#1111 = 2
  
  
  /** addition, using class Rational as pure datatype */
  def addRational(r: Rational, s: Rational): Rational =
      new Rational(
          r.numer*s.denom+s.numer*r.denom,
          r.denom*s.denom)                        //> addRational: (r#914598: week2#31.Rational#896892, s#914599: week2#31.Rationa
                                                  //| l#896892)week2#31.Rational#896892
  def makeString(r:Rational) =
      r.numer + "/" + r.denom                     //> makeString: (r#914848: week2#31.Rational#896892)String#234
      
  val y = new Rational(2,3)                       //> y  : week2#31.Rational#896892 = week2.Rational@34ce8af7
 makeString( addRational(x,y)  )                  //> res2: String#234 = 7/6
}


class Rational(x: Int, y: Int) {
	def numer = x
	def denom = y
	
}