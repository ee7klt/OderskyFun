package week1

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(37); val res$0 = 
  1+3;System.out.println("""res0: Int(4) = """ + $show(res$0));$skip(378); 
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
		
	};System.out.println("""sqrt: (x: Double)Double""");$skip(11); val res$1 = 

	sqrt(4);System.out.println("""res1: Double = """ + $show(res$1));$skip(35); ;
	
		
	def hello(a: Int) = {
		3
	};System.out.println("""hello: (a: Int)Int""");$skip(13); val res$2 = 
	
	hello(2);System.out.println("""res2: Int = """ + $show(res$2));$skip(69); ;
	def there(b:Int) ={
	def hello(a: Int) = {
		2
	}
	
	hello(2);
	
	};System.out.println("""there: (b: Int)Int""");$skip(11); val res$3 = 
	there(2);;System.out.println("""res3: Int = """ + $show(res$3))}

}
