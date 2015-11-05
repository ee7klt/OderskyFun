package week2

object exercises {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  /** Write a product function that calculates
  	  the products of the values of a function
  	  for the points on a given interval */
  	  
  def product (f: Int => Int)(a: Int, b: Int): Int =
  	if (a > b) 1 else f(a) * product(f)(a+1,b)//> product: (f#705069: Int#1111 => Int#1111)(a#705070: Int#1111, b#705071: Int#
                                                  //| 1111)Int#1111
  	
  product(x => x+1)(1,3)                          //> res0: Int#1111 = 24
  
  
  /** Write factorial in terms of product */
  def factorial (x: Int): Int =
  	product(d => d)(1,x)                      //> factorial: (x#705324: Int#1111)Int#1111
  	
 factorial(5)                                     //> res1: Int#1111 = 120
 
 /**Can you write a more general function,
 which generalizes both sum and product? */
 
 	def mapReduce (f: Int => Int, combine: (Int,Int) => Int, zero: Int)(a: Int, b: Int): Int =
 		if (a>b) zero else combine(f(a), mapReduce(f,combine,zero)(a+1,b))
                                                  //> mapReduce: (f#705327: Int#1111 => Int#1111, combine#705328: (Int#1111, Int#1
                                                  //| 111) => Int#1111, zero#705329: Int#1111)(a#705330: Int#1111, b#705331: Int#1
                                                  //| 111)Int#1111
 
	mapReduce(x => x*x, (x,y) => x+y, 1)(1,3) //> res2: Int#1111 = 15
	
	def mapReduce_product (f:Int => Int)(a: Int, b: Int): Int =
		mapReduce(f, (x,y) => x*y, 1)(a,b)//> mapReduce_product: (f#705347: Int#1111 => Int#1111)(a#705348: Int#1111, b#70
                                                  //| 5349: Int#1111)Int#1111
		
	mapReduce_product(x=>x*x)(1,3)            //> res3: Int#1111 = 36
	
	def mapReduce_sum(f:Int => Int)(a: Int, b: Int): Int =
		mapReduce(f, (x,y) => x+y, 0)(a,b)//> mapReduce_sum: (f#705359: Int#1111 => Int#1111)(a#705360: Int#1111, b#70536
                                                  //| 1: Int#1111)Int#1111
	mapReduce_sum(x=>x*x)(1,3)                //> res4: Int#1111 = 14
}