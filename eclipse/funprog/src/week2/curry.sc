package week2

object curry {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def curriedSum(x:Int)(y:Int)(z:Int) = x+y+z     //> curriedSum: (x#706536: Int#1111)(y#706537: Int#1111)(z#706538: Int#1111)Int#
                                                  //| 1111
  
  	def f(x:Int) = ((y:Int) => ((z:Int) => x+y+z))
                                                  //> f: (x#706527: Int#1111)Int#1111 => (Int#1111 => Int#1111)
 		val b = f(1)                      //> b  : Int#1111 => (Int#1111 => Int#1111) = <function1>
 		val c = b(2)                      //> c  : Int#1111 => Int#1111 = <function1>
 		c(3)                              //> res0: Int#1111 = 6

  def k = curriedSum(1)_                          //> k: => Int#1111 => (Int#1111 => Int#1111)
  def l =k(2)                                     //> l: => Int#1111 => Int#1111
  l(3)                                            //> res1: Int#1111 = 6
  
  k(2)(3)                                         //> res2: Int#1111 = 6
 
  def m =curriedSum(1)(_:Int)(_:Int)              //> m: => (Int#1111, Int#1111) => Int#1111
  m(2,3)                                          //> res3: Int#1111 = 6
  
  
  
  
  
  def sum(f: Int => Int)(a: Int, b: Int): Int =
	 	if (a >b) 0 else f(a) + sum(f)(a+1,b)
                                                  //> sum: (f#706555: Int#1111 => Int#1111)(a#706556: Int#1111, b#706557: Int#1111
                                                  //| )Int#1111
  def temp0 = sum(x=>x)_                          //> temp0: => (Int#1111, Int#1111) => Int#1111
  
  def sum1(f: Int => Int) = {
		(a: Int, b: Int) => {
  		if (a >b) 0 else f(a) + sum(f)(a+1,b);
  		}
  }                                               //> sum1: (f#706812: Int#1111 => Int#1111)(Int#1111, Int#1111) => Int#1111
  
  def sum3(f: Int => Int): Int = {
		def g(a: Int, b: Int): Int =
  		if (a >b) 0 else f(a) + sum(f)(a+1,b);
  	0
  /**	g */
  }                                               //> sum3: (f#706821: Int#1111 => Int#1111)Int#1111
  
  sum (x => x)(1,3)                               //> res4: Int#1111 = 6
  def temp = sum1(x => x)                         //> temp: => (Int#1111, Int#1111) => Int#1111
  temp(1,3)                                       //> res5: Int#1111 = 6
  
  
  def sum2 = (f: Int => Int) => (a: Int, b:Int) => if (a >b) 0 else f(a) + sum(f)(a+1,b)
                                                  //> sum2: => (Int#1111 => Int#1111) => ((Int#1111, Int#1111) => Int#1111)
  def temp2 = sum2(x => x)                        //> temp2: => (Int#1111, Int#1111) => Int#1111
 	temp2(1,3)                                //> res6: Int#1111 = 6
  
  }