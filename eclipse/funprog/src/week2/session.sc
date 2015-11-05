package week2

object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  //sum of all integers between a and b
  def sumInts(a: Int, b: Int): Int =
  	if (a > b) 0 else a + sumInts(a+1,b)      //> sumInts: (a#728925: Int#1111, b#728926: Int#1111)Int#1111
  
  sumInts(4,5)                                    //> res0: Int#1111 = 9
  
  def cube(x: Int): Int = x*x*x                   //> cube: (x#729174: Int#1111)Int#1111
  
  
  //sum of cubes of all integers between a and b
  def sumCubes(a: Int, b: Int): Int =
  	if (a > b) 0 else cube(a) + sumCubes(a+1,b)
                                                  //> sumCubes: (a#729178: Int#1111, b#729179: Int#1111)Int#1111
  	
  sumCubes(2,4)                                   //> res1: Int#1111 = 99
  
  //sum of factorials of all integers between a and b
  def fact(x: Int): Int =
  	if (x == 0) 1 else x*fact(x-1)            //> fact: (x#729185: Int#1111)Int#1111
  	
  	
  def sumFact(a: Int, b: Int): Int =
  	if (a > b) 0 else fact(a) + sumFact(a+1,b)//> sumFact: (a#729191: Int#1111, b#729192: Int#1111)Int#1111
  	
  fact(3)                                         //> res2: Int#1111 = 6
  sumFact(1,3)                                    //> res3: Int#1111 = 9
  
  
  //Summing with Higher-Order functions
  // f is a paramter of sum function
  
  def sum(f: Int => Int, a: Int, b: Int): Int =
  	if (a>b) 0 else f(a) + sum(f,a+1,b)       //> sum: (f#729198: Int#1111 => Int#1111, a#729199: Int#1111, b#729200: Int#1111
                                                  //| )Int#1111
  	
  	
  def sumIntsHO(a: Int, b: Int) = sum(id, a, b)   //> sumIntsHO: (a#729207: Int#1111, b#729208: Int#1111)Int#1111
  def sumCubesHO(a: Int, b: Int) = sum(cube, a, b)//> sumCubesHO: (a#729212: Int#1111, b#729213: Int#1111)Int#1111
  def sumFactHO(a: Int, b: Int) = sum(fact, a, b) //> sumFactHO: (a#729216: Int#1111, b#729217: Int#1111)Int#1111
  
  def id(x: Int): Int = x                         //> id: (x#729209: Int#1111)Int#1111
  
  
  sumIntsHO(1,3)                                  //> res4: Int#1111 = 6
  sumCubesHO(1,3)                                 //> res5: Int#1111 = 36
  sumFactHO(1,3)                                  //> res6: Int#1111 = 9
  
  //Summing using anonymous functions
  
  def sumIntsAny(a: Int, b: Int) = sum(x=> x,a,b) //> sumIntsAny: (a#729220: Int#1111, b#729221: Int#1111)Int#1111
  sumIntsAny(2,3)                                 //> res7: Int#1111 = 5
  
  //Exercise: write tail recursive version of sum
  // unlike factorial, sum can actually profit from tail recursion
  // if distance between a and b is large, can lead to stack overflow
  def tailsum(f: Int => Int, a: Int, b: Int): Int = {
  
  	def loop(a: Int, acc: Int): Int = {
  		if (a == b) acc else loop(a+1, acc+f(a))
  	}
  	loop(a,f(b))
  }                                               //> tailsum: (f#729224: Int#1111 => Int#1111, a#729225: Int#1111, b#729226: Int
                                                  //| #1111)Int#1111
 
  
  	tailsum(fact,1,3)                         //> res8: Int#1111 = 9
  	tailsum(x=>x*x,3,5)                       //> res9: Int#1111 = 50
  	
  	
  	def oderskytailsum(f: Int => Int, a: Int, b: Int) = {
  		def loop(a:Int, acc: Int): Int =
  			if (a>b) acc
  			else loop(a+1, f(a) + acc)
  		loop(a,0)
  	}                                         //> oderskytailsum: (f#729242: Int#1111 => Int#1111, a#729243: Int#1111, b#7292
                                                  //| 44: Int#1111)Int#1111
  
  oderskytailsum(x=>x*x,3,5)                      //> res10: Int#1111 = 50
 		
 		
 		def sum_curry(f: Int => Int): (Int,Int) => Int = {
 			def sumF(a:Int, b:Int): Int =
 				if (a > b) 0
 					else f(a) + sumF(a+1,b)
 			sumF
 		}                                 //> sum_curry: (f#729258: Int#1111 => Int#1111)(Int#1111, Int#1111) => Int#1111
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
    	if (a > b) 0 else f(a) + sum_mpl(f)(a+1,b)//> sum_mpl: (f#729286: Int#1111 => Int#1111)(a#729287: Int#1111, b#729288: Int
                                                  //| #1111)Int#1111
   
   sum_mpl(x => x)(1,3)                           //> res16: Int#1111 = 6
     
     
     def curriedSum(x:Int)(y:Int) = x+y           //> curriedSum: (x#728904: Int#1111)(y#728905: Int#1111)Int#1111
     curriedSum(1)(2)                             //> res17: Int#1111 = 3
 		/** curried function is series of traditional function invocations back to back */
 		def first(x:Int) = (y:Int) => x + y
                                                  //> first: (x#728900: Int#1111)Int#1111 => Int#1111
 		val second = first(1)             //> second  : Int#1111 => Int#1111 = <function1>
 		second(2)                         //> res18: Int#1111 = 3
 		
 		/** placeholder notation in partially applied function expression */
 		val onePlus = curriedSum(1)_      //> onePlus  : Int#1111 => Int#1111 = <function1>
 		onePlus(2)                        //> res19: Int#1111 = 3
 		
 		def f(x:Int) = (y:Int) => x+y     //> f: (x#728909: Int#1111)Int#1111 => Int#1111
 		val a = f(2)                      //> a  : Int#1111 => Int#1111 = <function1>
 		a(4)                              //> res20: Int#1111 = 6
 		
 		
 		def curriedSumThree(x:Int)(y:Int)(z:Int) = x + y + z
                                                  //> curriedSumThree: (x#728913: Int#1111)(y#728914: Int#1111)(z#728915: Int#111
                                                  //| 1)Int#1111
    val one = curriedSumThree(1)_                 //> one  : Int#1111 => (Int#1111 => Int#1111) = <function1>
 		val two = one(2)(4)               //> two  : Int#1111 = 7
 		
 		
 		def line(a: Int, b: Int, x: Int): Int = a*x +b
                                                  //> line: (a#729300: Int#1111, b#729301: Int#1111, x#729302: Int#1111)Int#1111
 		def curriedLine(a:Int)(b:Int)(x:Int): Int = line(a,b,x)
                                                  //> curriedLine: (a#729306: Int#1111)(b#729307: Int#1111)(x#729308: Int#1111)In
                                                  //| t#1111
 		def defaultLine(x: Int): Int = curriedLine(1)(0)(x)
                                                  //> defaultLine: (x#729309: Int#1111)Int#1111
 		
 		defaultLine(5)                    //> res21: Int#1111 = 5
 		def curryIt = (line _).curried    //> curryIt: => Int#1111 => (Int#1111 => (Int#1111 => Int#1111))
 		
 	
}