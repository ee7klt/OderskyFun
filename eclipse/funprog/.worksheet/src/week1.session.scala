package week1

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(37); val res$0 = 
  1+3;System.out.println("""res0: Int(4) = """ + $show(res$0));$skip(42); 
  def abs(x: Double) = if (x<0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(124); 
  def sqrtIter(guess: Double, x: Double): Double =
  	if (isGoodEnough(guess,x)) guess
  	else sqrtIter(improve(guess,x),x);System.out.println("""sqrtIter: (guess: Double, x: Double)Double""");$skip(114); 
  	
  def isGoodEnough(guess: Double, x: Double): Boolean = {
  	if (x > 1)
  		return (abs(guess*guess-x) < x)
};System.out.println("""isGoodEnough: (guess: Double, x: Double)Boolean""");$skip(63); 
	def improve(guess: Double, x: Double) =
		(guess + x/guess)/2;System.out.println("""improve: (guess: Double, x: Double)Double""");$skip(38); 
	def sqrt(x:Double) = sqrtIter(1.0,x);System.out.println("""sqrt: (x: Double)Double""");$skip(11); val res$1 = 
	
	sqrt(2);System.out.println("""res1: Double = """ + $show(res$1));$skip(9); val res$2 = 
	sqrt(4);System.out.println("""res2: Double = """ + $show(res$2));$skip(13); val res$3 = 
	sqrt(0.001);System.out.println("""res3: Double = """ + $show(res$3));$skip(41); val res$4 = 
	0.04124542607499115*0.04124542607499115;System.out.println("""res4: Double(0.0017011851721075596) = """ + $show(res$4));$skip(13); val res$5 = 
	sqrt(1e-20);System.out.println("""res5: Double = """ + $show(res$5));$skip(43); val res$6 = 
	6.103515625005462E-5*6.103515625005462E-5;System.out.println("""res6: Double(3.725290298468581E-9) = """ + $show(res$6));$skip(16); val res$7 = 
	sqrt(1.45e130);System.out.println("""res7: Double = """ + $show(res$7));$skip(45); val res$8 = 
	1.2041594578792295E15*1.2041594578792295E15;System.out.println("""res8: Double(1.45E30) = """ + $show(res$8))}
}
