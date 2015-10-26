package week2

object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  //sum of all integers between a and b
  def sumInts(a: Int, b: Int): Int =
  	if (a > b) 0 else a + sumInts(a+1,b)      //> sumInts: (a#345681: Int#1111, b#345682: Int#1111)Int#1111
  
  sumInts(4,5)                                    //> res0: Int#1111 = 9
  
  def cube(x: Int): Int = x*x*x                   //> cube: (x#345930: Int#1111)Int#1111
  
  
  //sum of cubes of all integers between a and b
  def sumCubes(a: Int, b: Int): Int =
  	if (a > b) 0 else cube(a) + sumCubes(a+1,b)
                                                  //> sumCubes: (a#345934: Int#1111, b#345935: Int#1111)Int#1111
  	
  sumCubes(2,4)                                   //> res1: Int#1111 = 99
  
  //sum of factorials of all integers between a and b
  def fact(x: Int): Int =
  	if (x == 0) 1 else x*fact(x-1)            //> fact: (x#345941: Int#1111)Int#1111
  	
  	
  def sumFact(a: Int, b: Int): Int =
  	if (a > b) 0 else fact(a) + sumFact(a+1,b)//> sumFact: (a#345947: Int#1111, b#345948: Int#1111)Int#1111
  	
  fact(3)                                         //> res2: Int#1111 = 6
  sumFact(1,3)                                    //> res3: Int#1111 = 9
  
  
  //Summing with Higher-Order functions
  // f is a paramter of sum function
  
  def sum(f: Int => Int, a: Int, b: Int): Int =
  	if (a>b) 0 else f(a) + sum(f,a+1,b)       //> sum: (f#345954: Int#1111 => Int#1111, a#345955: Int#1111, b#345956: Int#1111
                                                  //| )Int#1111
  	
  	
  def sumIntsHO(a: Int, b: Int) = sum(id, a, b)   //> sumIntsHO: (a#345963: Int#1111, b#345964: Int#1111)Int#1111
  def sumCubesHO(a: Int, b: Int) = sum(cube, a, b)//> sumCubesHO: (a#345968: Int#1111, b#345969: Int#1111)Int#1111
  def sumFactHO(a: Int, b: Int) = sum(fact, a, b) //> sumFactHO: (a#345972: Int#1111, b#345973: Int#1111)Int#1111
  
  def id(x: Int): Int = x                         //> id: (x#345965: Int#1111)Int#1111
  
  
  sumIntsHO(1,3)                                  //> res4: Int#1111 = 6
  sumCubesHO(1,3)                                 //> res5: Int#1111 = 36
  sumFactHO(1,3)                                  //> res6: Int#1111 = 9
  
  //Summing using anonymous functions
  
  def sumIntsAny(a: Int, b: Int) = sum(x=> x,a,b) //> sumIntsAny: (a#345976: Int#1111, b#345977: Int#1111)Int#1111
  sumIntsAny(2,3)                                 //> res7: Int#1111 = 5
  
  //Exercise: write tail recursive version of sum
  // unlike factorial, sum can actually profit from tail recursion
  // if distance between a and b is large, can lead to stack overflow
  def tailsum(f: Int => Int, a: Int, b: Int): Int = {
  
  	def loop(a: Int, acc: Int): Int = {
  		if (a == b) acc else loop(a+1, acc+f(a))
  	}
  	loop(a,f(b))
  }                                               //> tailsum: (f#345980: Int#1111 => Int#1111, a#345981: Int#1111, b#345982: Int
                                                  //| #1111)Int#1111
 
  
  	tailsum(fact,1,3)                         //> res8: Int#1111 = 9
  	tailsum(x=>x*x,3,5)                       //> res9: Int#1111 = 50
  	
  	
  	def oderskytailsum(f: Int => Int, a: Int, b: Int) = {
  		def loop(a:Int, acc: Int): Int =
  			if (a>b) acc
  			else loop(a+1, f(a) + acc)
  		loop(a,0)
  	}                                         //> oderskytailsum: (f#345998: Int#1111 => Int#1111, a#345999: Int#1111, b#3460
                                                  //| 00: Int#1111)Int#1111
  
  oderskytailsum(x=>x*x,3,5)                      //> res10: Int#1111 = 50
 		
 		
 		def sum_curry(f: Int => Int): (Int,Int) => Int = {
 			def sumF(a:Int, b:Int): Int =
 				if (a > b) 0
 					else f(a) + sumF(a+1,b)
 			sumF
 		}                                 //> sum_curry: (f#346014: Int#1111 => Int#1111)(Int#1111, Int#1111) => Int#1111
                                                  //| 
 		
 		def sumInts_curr = sum_curry(x => x)
                                                  //> sumInts_curr: => (Int#1111, Int#1111) => Int#1111
 		sumInts_curr(3,5)                 //> res11: Int#1111 = 12
 		
 		def sumCubes_curr = sum_curry(x => x*x*x)
                                                  //> sumCubes_curr: => (Int#1111, Int#1111) => Int#1111
 		sumCubes_curr(1,3)                //> res12: Int#1111 = 36
 		def sumFact_curr = sum_curry(fact)//> sumFact_curr: => (Int#1111, Int#1111) => Int#1111
 		sumFact_curr(1,3)                 //> res13: Int#1111 = 9
 		
 		sum_curry(x=>x)(1,3)              //> res14: Int#1111 = 6
 		def sumCube_curry = sum_curry(cube)
                                                  //> sumCube_curry: => (Int#1111, Int#1111) => Int#1111
                             sumCube_curry(1,3)   //> res15: Int#1111 = 36
           
    /** multiple parameter list sum */
   def sum_mpl(f: Int => Int)(a: Int, b: Int): Int =
    	if (a > b) 0 else f(a) + sum_mpl(f)(a+1,b)//> sum_mpl: (f#346042: Int#1111 => Int#1111)(a#346043: Int#1111, b#346044: Int
                                                  //| #1111)Int#1111
   
   sum_mpl(x => x)(1,3)                           //> res16: Int#1111 = 6
     
     
     def curriedSum(x:Int)(y:Int) = x+y           //> curriedSum: (x#345660: Int#1111)(y#345661: Int#1111)Int#1111
     curriedSum(1)(2)                             //> res17: Int#1111 = 3
 		/** curried function is series of traditional function invocations back to back */
 		def first(x:Int) = (y:Int) => x + y
                                                  //> first: (x#345656: Int#1111)Int#1111 => Int#1111
 		val second = first(1)             //> second  : Int#1111 => Int#1111 = <function1>
 		second(2)                         //> res18: Int#1111 = 3
 		
 		/** placeholder notation in partially applied function expression */
 		val onePlus = curriedSum(1)_      //> onePlus  : Int#1111 => Int#1111 = <function1>
 		onePlus(2)                        //> res19: Int#1111 = 3
 		
 		def f(x:Int) = (y:Int) => x+y     //> f: (x#345665: Int#1111)Int#1111 => Int#1111
 		val a = f(2)                      //> a  : Int#1111 => Int#1111 = <function1>
 		a(4)                              //> res20: Int#1111 = 6
 		
 		
 		def curriedSumThree(x:Int)(y:Int)(z:Int) = x + y + z
                                                  //> curriedSumThree: (x#345669: Int#1111)(y#345670: Int#1111)(z#345671: Int#111
                                                  //| 1)Int#1111
    val one = curriedSumThree(1)_                 //> one  : Int#1111 => (Int#1111 => Int#1111) = <function1>
 		val two = one(2)(4)               //> two  : Int#1111 = 7
 		
 		
 	
}