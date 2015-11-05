package week2
import math.abs

/** solve f(x) = x iteratively */


object fixed_points {
  println("Welcome to Fixed Points")              //> Welcome to Fixed Points
  val tolerance = 0.0001                          //> tolerance  : Double#1627 = 1.0E-4
  def isCloseEnough(x: Double, y: Double) =
  	abs((x-y)/x) < tolerance                  //> isCloseEnough: (x#771102: Double#1627, y#771103: Double#1627)Boolean#2533
  
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
  	def iterate(guess: Double): Double = {
  		val next = f(guess)
  		if (isCloseEnough(guess, next)) next
  		else iterate(next)
  	}
  	iterate(firstGuess)
  }                                               //> fixedPoint: (f#771108: Double#1627 => Double#1627)(firstGuess#771109: Double
                                                  //| #1627)Double#1627
  
  
 fixedPoint(x => 1+x/2)(1)                        //> res0: Double#1627 = 1.9998779296875
  
  
  
}