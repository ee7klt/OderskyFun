package week2

object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  //sum of all integers between a and b
  def sumInts(a: Int, b: Int): Int =
  	if (a > b) 0 else a + sumInts(a+1,b)      //> sumInts: (a#183035: Int#1111, b#183036: Int#1111)Int#1111
  
  sumInts(4,5)                                    //> res0: Int#1111 = 9
  
  def cube(x: Int): Int = x*x*x                   //> cube: (x#183284: Int#1111)Int#1111
  
  
  //sum of cubes of all integers between a and b
  def sumCubes(a: Int, b: Int): Int =
  	if (a > b) 0 else cube(a) + sumCubes(a+1,b)
                                                  //> sumCubes: (a#183288: Int#1111, b#183289: Int#1111)Int#1111
  	
  sumCubes(2,4)                                   //> res1: Int#1111 = 99
  
  //sum of factorials of all integers between a and b
  def fact(x: Int): Int =
  	if (x == 0) 1 else x*fact(x-1)            //> fact: (x#183295: Int#1111)Int#1111
  	
  	
  def sumFact(a: Int, b: Int): Int =
  	if (a > b) 0 else fact(a) + sumFact(a+1,b)//> sumFact: (a#183301: Int#1111, b#183302: Int#1111)Int#1111
  	
  fact(3)                                         //> res2: Int#1111 = 6
  sumFact(1,3)                                    //> res3: Int#1111 = 9
  
  
  //Summing with Higher-Order functions
  // f is a paramter of sum function
  
  def sum(f: Int => Int, a: Int, b: Int): Int =
  	if (a>b) 0 else f(a) + sum(f,a+1,b)       //> sum: (f#183308: Int#1111 => Int#1111, a#183309: Int#1111, b#183310: Int#1111
                                                  //| )Int#1111
  	
  	
  def sumIntsHO(a: Int, b: Int) = sum(id, a, b)   //> sumIntsHO: (a#183317: Int#1111, b#183318: Int#1111)Int#1111
  def sumCubesHO(a: Int, b: Int) = sum(cube, a, b)//> sumCubesHO: (a#183322: Int#1111, b#183323: Int#1111)Int#1111
  def sumFactHO(a: Int, b: Int) = sum(fact, a, b) //> sumFactHO: (a#183326: Int#1111, b#183327: Int#1111)Int#1111
  
  def id(x: Int): Int = x                         //> id: (x#183319: Int#1111)Int#1111
  
  
  sumIntsHO(1,3)                                  //> res4: Int#1111 = 6
  sumCubesHO(1,3)                                 //> res5: Int#1111 = 36
  sumFactHO(1,3)                                  //> res6: Int#1111 = 9
  
  //Summing using anonymous functions
  
  def sumIntsAny(a: Int, b: Int) = sum(x=> x,a,b) //> sumIntsAny: (a#183330: Int#1111, b#183331: Int#1111)Int#1111
  sumIntsAny(2,3)                                 //> res7: Int#1111 = 5
  
  //Exercise: write tail recursive version of sum
  // unlike factorial, sum can actually profit from tail recursion
  // if distance between a and b is large, can lead to stack overflow
  def tailsum(f: Int => Int, a: Int, b: Int): Int = {
  
  	def loop(a: Int, acc: Int): Int = {
  		if (a == b) acc else loop(a+1, acc+f(a))
  	}
  	loop(a,f(b))
  }                                               //> tailsum: (f#183334: Int#1111 => Int#1111, a#183335: Int#1111, b#183336: Int
                                                  //| #1111)Int#1111
 
  
  	tailsum(fact,1,3)                         //> res8: Int#1111 = 9
  
 		
 		
 		
}