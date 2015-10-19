package week1


object session {
import scala.annotation.tailrec
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
		
	}                                         //> sqrt: (x#184346: Double#1627)Double#1627

	sqrt(4);                                  //> res0: Double#1627 = 2.0000000929222947
	
		
	def hello(a: Int) = {
		3
	}                                         //> hello: (a#184363: Int#1111)Int#1111
	
	hello(2);                                 //> res1: Int#1111 = 3
	def there(b:Int) ={
	def hello(a: Int) = {
		2
	}
	
	hello(2);
	
	}                                         //> there: (b#184364: Int#1111)Int#1111
	there(2);                                 //> res2: Int#1111 = 2
	
	
	val x = 0;                                //> x  : Int#1111 = 0
	def f(y: Int) = y +1                      //> f: (y#184342: Int#1111)Int#1111
	val result = {
		val x = f(3)
		x*x
	} + x                                     //> result  : Int#1111 = 16
	
	
	def gcd(a: Int, b: Int): Int = {
		if (b==0) a else {
			println("b = " + b + ", a mod b =  " + a%b)
			gcd(b, a%b)
			}
	}                                         //> gcd: (a#184367: Int#1111, b#184368: Int#1111)Int#1111
	gcd(14,21);                               //> b = 21, a mod b =  14
                                                  //| b = 14, a mod b =  7
                                                  //| b = 7, a mod b =  0
                                                  //| res3: Int#1111 = 7
                                                  
                                                  
     def factorial(n: Int): Int =
     	if (n == 0) 1 else {
     	  println (n + " " + (n-1))
     		n* factorial(n-1)
     		}                                 //> factorial: (n#184616: Int#1111)Int#1111
     	
     
     
     factorial(4)                                 //> 4 3
                                                  //| 3 2
                                                  //| 2 1
                                                  //| 1 0
                                                  //| res4: Int#1111 = 24
                                                  
                                                  

      	def tailfactorial (n: Int):  Int = {
      		def loop(n: Int, acc: Int): Int = {
      			if (n == 1) acc else loop(n-1, acc*n)
      		}
     			loop(n,1)
      	 }                                        //> tailfactorial: (n#184625: Int#1111)Int#1111
      	 
      	tailfactorial(5)                          //> res5: Int#1111 = 120

}