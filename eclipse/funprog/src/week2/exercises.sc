package week2

object exercises {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  /** Write a product function that calculates
  	  the products of the values of a function
  	  for the points on a given interval */
  	  
  def product (f: Int => Int)(a: Int, b: Int): Int =
  	if (a > b) 1 else f(a) * product(f)(a+1,b)//> product: (f#666861: Int#1111 => Int#1111)(a#666862: Int#1111, b#666863: Int#
                                                  //| 1111)Int#1111
  	
  product(x => x+1)(1,3)                          //> res0: Int#1111 = 24
  
  
  /** Write factorial in terms of product */
  def factorial (x: Int): Int =
  	product(d => d)(1,x)                      //> factorial: (x#667116: Int#1111)Int#1111
  	
 factorial(5)                                     //> res1: Int#1111 = 120
 
 /**Can you write a more general function,
 which generalizes both sum and product? */
 
 	def mapReduce (f: Int => Int, combine: (Int,Int) => Int, zero: Int)(a: Int, b: Int): Int =
 		if (a>b) zero else combine(f(a), mapReduce(f,combine,zero)(a+1,b))
                                                  //> mapReduce: (f#667119: Int#1111 => Int#1111, combine#667120: (Int#1111, Int#1
                                                  //| 111) => Int#1111, zero#667121: Int#1111)(a#667122: Int#1111, b#667123: Int#1
                                                  //| 111)Int#1111
 
	mapReduce(x => x*x, (x,y) => x+y, 1)(1,3) //> res2: Int#1111 = 15
}