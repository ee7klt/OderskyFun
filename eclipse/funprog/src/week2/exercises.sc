package week2

object exercises {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  /** Write a product function that calculates
  	  the products of the values of a function
  	  for the points on a given interval */
  	  
  def product (f: Int => Int)(a: Int, b: Int): Int =
  	if (a > b) 1 else f(a) * product(f)(a+1,b)//> product: (f#443268: Int#1111 => Int#1111)(a#443269: Int#1111, b#443270: Int#
                                                  //| 1111)Int#1111
  	
  product(x => x+1)(1,3)                          //> res0: Int#1111 = 24
  
  
  /** Write factorial in terms of product */
  def factorial (x: Int): Int =
  	product(d => d)(1,x)                      //> factorial: (x#443523: Int#1111)Int#1111
  	
 factorial(5)                                     //> res1: Int#1111 = 120
 
 /**Can you write a more general function,
 which generalizes both sum and product? */
 
 
}