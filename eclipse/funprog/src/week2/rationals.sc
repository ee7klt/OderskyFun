package week2

object rationals {
  val x = new Rational(1, 2)                      //> x  : week2.Rational = 1/2
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 2

  /** addition, using class Rational as pure datatype (outside class) */
  def addRational(r: Rational, s: Rational): Rational =
    new Rational(
      r.numer * s.denom + s.numer * r.denom,
      r.denom * s.denom)                          //> addRational: (r: week2.Rational, s: week2.Rational)week2.Rational
  def makeString(r: Rational) =
    r.numer + "/" + r.denom                       //> makeString: (r: week2.Rational)String

  val y = new Rational(2, 3)                      //> y  : week2.Rational = 2/3
  makeString(addRational(x, y))                   //> res2: String = 7/6

  x.add(y)                                        //> res3: week2.Rational = 7/6
  x.neg                                           //> res4: week2.Rational = -1/2
	x.subtract(y)                             //> res5: week2.Rational = -1/6

}

class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y

  /** addition using methods */
  /** method = functions put in to class */

  def add(that: Rational) =
    /** takes only one arg vs. addRational */

    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  override def toString =
    numer + "/" + denom

  def neg =
    new Rational(-numer, denom)
  
  def subtract(that:Rational) =
  	this.add(that.neg)

}