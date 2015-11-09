package week2
import math.abs

/** solve f(x) = x iteratively */


object fixed_points {
  println("Welcome to Fixed Points")              //> Welcome to Fixed Points
  val tolerance = 0.0001                          //> tolerance  : Double#1627 = 1.0E-4
  def isCloseEnough(x: Double, y: Double) =
  	abs((x-y)/x) < tolerance                  //> isCloseEnough: (x#803207: Double#1627, y#803208: Double#1627)Boolean#2533
  
  
  /** (Double => Double)(Double) => Double */
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
  	def iterate(guess: Double): Double = {
  		println(guess)
  		val next = f(guess)
  		if (isCloseEnough(guess, next)) next
  		else iterate(next)
  	}
  	iterate(firstGuess)
  }                                               //> fixedPoint: (f#803213: Double#1627 => Double#1627)(firstGuess#803214: Double
                                                  //| #1627)Double#1627
  
  
 fixedPoint(x => 1+x/2)(1)                        //> 1.0
                                                  //| 1.5
                                                  //| 1.75
                                                  //| 1.875
                                                  //| 1.9375
                                                  //| 1.96875
                                                  //| 1.984375
                                                  //| 1.9921875
                                                  //| 1.99609375
                                                  //| 1.998046875
                                                  //| 1.9990234375
                                                  //| 1.99951171875
                                                  //| 1.999755859375
                                                  //| res0: Double#1627 = 1.9998779296875
  
  
  def sqrt(x: Double) =
  fixedPoint(y => (x/y+y)/2)(1.0)                 //> sqrt: (x#803468: Double#1627)Double#1627
  
  sqrt(4)                                         //> 1.0
                                                  //| 2.5
                                                  //| 2.05
                                                  //| 2.000609756097561
                                                  //| 2.0000000929222947
                                                  //| res1: Double#1627 = 2.000000000000002
  
  
  
}