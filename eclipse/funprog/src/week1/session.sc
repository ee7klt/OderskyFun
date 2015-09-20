package week1

object session {
  1+3                                             //> res0: Int(4) = 4
  def sqrt(x: Double) = {
  def abs(x: Double) = if (x<0) -x else x
  def sqrtIter(guess: Double): Double =
  	if (isGoodEnough(guess)) guess
  	else sqrtIter(improve(guess))
  	
  def isGoodEnough(guess: Double): Boolean =
  	abs(guess*guess-x) < .0001*x
  
	def improve(guess: Double) =
		(guess + x/guess)/2
		
		sqrtIter(1.0);
		
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
	
	
	val x = 0;                                //> x  : Int = 0
	def f(y: Int) = y +1                      //> f: (y: Int)Int
	val result = {
		val x = f(3)
		x*x
	} + x                                     //> result  : Int = 16
	
	
	def gcd(a: Int, b: Int): Int = {
		if (b==0) a else {
			println("b = " + b + ", a mod b =  " + a%b)
			gcd(b, a%b)
			}
	}                                         //> gcd: (a: Int, b: Int)Int
	gcd(14,21);                               //> b = 21, a mod b =  14
                                                  //| b = 14, a mod b =  7
                                                  //| b = 7, a mod b =  0
                                                  //| res4: Int = 7
                                                  
                                                  
     def factorial(n: Int): Int =
     	if (n == 0) 1 else {
     	  println (n + " " + (n-1))
     		n* factorial(n-1)
     		}                                 //> factorial: (n: Int)Int
     	
     
     
     factorial(4)                                 //> 4 3
                                                  //| 3 2
                                                  //| 2 1
                                                  //| 1 0
                                                  //| res5: Int = 24

}