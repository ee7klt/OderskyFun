package week1

object session {
  1+3                                             //> res0: Int(4) = 4
  def abs(x: Double) = if (x<0) -x else x         //> abs: (x: Double)Double
  def sqrtIter(guess: Double, x: Double): Double =
  	if (isGoodEnough(guess,x)) guess
  	else sqrtIter(improve(guess,x),x)         //> sqrtIter: (guess: Double, x: Double)Double
  	
  def isGoodEnough(guess: Double, x: Double): Boolean =
  	abs(guess*guess-x) < .0001*x              //> isGoodEnough: (guess: Double, x: Double)Boolean
  
	def improve(guess: Double, x: Double) =
		(guess + x/guess)/2               //> improve: (guess: Double, x: Double)Double
		
	def sqrt(x:Double) = sqrtIter(1.0,x)      //> sqrt: (x: Double)Double
	
	sqrt(2)                                   //> res1: Double = 1.4142156862745097
	sqrt(4)                                   //> res2: Double = 2.0000000929222947
	sqrt(0.001)                               //> res3: Double = 0.03162278245070105
	0.04124542607499115*0.04124542607499115   //> res4: Double(0.0017011851721075596) = 0.0017011851721075596
	sqrt(1e-20)                               //> res5: Double = 1.0000021484861236E-10
	sqrt(1e-20)*sqrt(1e-20)                   //> res6: Double = 1.0000042969768631E-20
	sqrt(1.45e130)                            //> res7: Double = 1.204161474260955E65
	sqrt(1.45e130)*sqrt(1.45e130)             //> res8: Double = 1.4500048560943167E130
}