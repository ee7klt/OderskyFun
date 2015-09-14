package week1

object session {
  1+3
  def abs(x: Double) = if (x<0) -x else x
  def sqrtIter(guess: Double, x: Double): Double =
  	if (isGoodEnough(guess,x)) guess
  	else sqrtIter(improve(guess,x),x)
  	
  def isGoodEnough(guess: Double, x: Double): Boolean = {
  	if (x > 1)
  		return (abs(guess*guess-x) < x)
}
	def improve(guess: Double, x: Double) =
		(guess + x/guess)/2
	def sqrt(x:Double) = sqrtIter(1.0,x)
	
	sqrt(2)
	sqrt(4)
	sqrt(0.001)
	0.04124542607499115*0.04124542607499115
	sqrt(1e-20)
	6.103515625005462E-5*6.103515625005462E-5
	sqrt(1.45e130)
	1.2041594578792295E15*1.2041594578792295E15
}