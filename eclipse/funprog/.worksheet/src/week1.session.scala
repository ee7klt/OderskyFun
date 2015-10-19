package week1


object session {
import scala.annotation.tailrec;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(401); 
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
		
	};System.out.println("""sqrt: (x#184346: Double#1627)Double#1627""");$skip(11); val res$0 = 

	sqrt(4);System.out.println("""res0: Double#1627 = """ + $show(res$0));$skip(35); ;
	
		
	def hello(a: Int) = {
		3
	};System.out.println("""hello: (a#184363: Int#1111)Int#1111""");$skip(13); val res$1 = 
	
	hello(2);System.out.println("""res1: Int#1111 = """ + $show(res$1));$skip(69); ;
	def there(b:Int) ={
	def hello(a: Int) = {
		2
	}
	
	hello(2);
	
	};System.out.println("""there: (b#184364: Int#1111)Int#1111""");$skip(11); val res$2 = 
	there(2);System.out.println("""res2: Int#1111 = """ + $show(res$2));$skip(16); ;
	
	
	val x = 0;System.out.println("""x  : Int#1111 = """ + $show(x ));$skip(22); ;
	def f(y: Int) = y +1;System.out.println("""f: (y#184342: Int#1111)Int#1111""");$skip(44); 
	val result = {
		val x = f(3)
		x*x
	} + x;System.out.println("""result  : Int#1111 = """ + $show(result ));$skip(129); 
	
	
	def gcd(a: Int, b: Int): Int = {
		if (b==0) a else {
			println("b = " + b + ", a mod b =  " + a%b)
			gcd(b, a%b)
			}
	};System.out.println("""gcd: (a#184367: Int#1111, b#184368: Int#1111)Int#1111""");$skip(13); val res$3 = 
	gcd(14,21);System.out.println("""res3: Int#1111 = """ + $show(res$3));$skip(231); ;
                                                  
                                                  
     def factorial(n: Int): Int =
     	if (n == 0) 1 else {
     	  println (n + " " + (n-1))
     		n* factorial(n-1)
     		};System.out.println("""factorial: (n#184616: Int#1111)Int#1111""");$skip(37); val res$4 = 
     	
     
     
     factorial(4);System.out.println("""res4: Int#1111 = """ + $show(res$4));$skip(276); 
                                                  
                                                  

      	def tailfactorial (n: Int):  Int = {
      		def loop(n: Int, acc: Int): Int = {
      			if (n == 1) acc else loop(n-1, acc*n)
      		}
     			loop(n,1)
      	 };System.out.println("""tailfactorial: (n#184625: Int#1111)Int#1111""");$skip(33); val res$5 = 
      	 
      	tailfactorial(5);System.out.println("""res5: Int#1111 = """ + $show(res$5))}

}
