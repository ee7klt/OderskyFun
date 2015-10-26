package week2

object curry {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def curriedSum(x:Int)(y:Int)(z:Int) = x+y+z     //> curriedSum: (x#378594: Int#1111)(y#378595: Int#1111)(z#378596: Int#1111)Int#
                                                  //| 1111
  val a = curriedSum(1)_                          //> a  : Int#1111 => (Int#1111 => Int#1111) = <function1>
  a(2)(3)                                         //> res0: Int#1111 = 6
  
  
  	def f(x:Int) = ((y:Int) => ((z:Int) => x+y+z))
                                                  //> f: (x#378603: Int#1111)Int#1111 => (Int#1111 => Int#1111)
 		val b = f(1)                      //> b  : Int#1111 => (Int#1111 => Int#1111) = <function1>
 		val c = b(2)                      //> c  : Int#1111 => Int#1111 = <function1>
 		c(3)                              //> res1: Int#1111 = 6
}