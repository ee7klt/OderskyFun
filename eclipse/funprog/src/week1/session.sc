package week1

object session {
  1+3                                             //> res0: Int(4) = 4
  def sqrt(x: Double) = {
  def abs(x: Double) = if (x<0) -x else x
  def sqrtIter(guess: Double, x: Double): Double =
  	if (isGoodEnough(guess,x)) guess
  	else sqrtIter(improve(guess,x),x)
  	
  def isGoodEnough(guess: Double, x: Double): Boolean =
  	abs(guess*guess-x) < .0001*x
  
	def improve(guess: Double, x: Double) =
		(guess + x/guess)/2
		
		sqrtIter(1.0,x);
		
	}                                         //> sqrt: (x: Double)Double

	sqrt(4);                                  //> res1: Double = 2.0000000929222947
	
		
	def hello(a: Int) = {
		3
	}                                         //> hello: (a: Int)Int
	
	hello(2);                                 //> res2: Int = 3
	def there(b:Int) ={
	def hello(a: Int) = {
		2
	}
	
	hello(2);
	
	}                                         //> there: (b: Int)Int
	there(2);                                 //> res3: Int = 2

}