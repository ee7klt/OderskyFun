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

  x + y                                           //> res3: week2.Rational = 7/6
  x + y                                           //> res4: week2.Rational = 7/6
  -x                                              //> res5: week2.Rational = 1/-2
  x.-(y)                                          //> res6: week2.Rational = 1/-6

  val z = new Rational(3, 2)                      //> z  : week2.Rational = 3/2
  x - y - z                                       //> res7: week2.Rational = -5/3
  x < y                                           //> res8: Boolean = true
  x.max(y)                                        //> res9: week2.Rational = 2/3
  new Rational(2)                                 //> res10: week2.Rational = 2/1
}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def numer = x
  def denom = y

  // when is this rational less than the other?
  def < (that: Rational) = this.numer * that.denom < that.numer * this.denom
  def max(that: Rational) = if (this < that) that else this

  /** addition using methods */
  /** method = functions put in to class */

  def + (that: Rational) =
    /** takes only one arg vs. addRational */

    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  override def toString = {
    val g = gcd(x, y)
    numer / g + "/" + denom / g
  }
  def unary_- : Rational =
    new Rational(-numer, denom)

  def - (that: Rational) =
    this + -that

}