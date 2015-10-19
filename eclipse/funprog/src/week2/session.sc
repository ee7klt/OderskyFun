package week2

object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  //sum of all integers between a and b
  def sumInts(a: Int, b: Int): Int =
  	if (a > b) 0 else a + sumInts(a+1,b)      //> sumInts: (a#204430: Int#1111, b#204431: Int#1111)Int#1111
  
  sumInts(4,5)                                    //> res0: Int#1111 = 9
  
  def cube(x: Int): Int = x*x*x                   //> cube: (x#204679: Int#1111)Int#1111
  
  
  //sum of cubes of all integers between a and b
  def sumCubes(a: Int, b: Int): Int =
  	if (a > b) 0 else cube(a) + sumCubes(a+1,b)
                                                  //> sumCubes: (a#204683: Int#1111, b#204684: Int#1111)Int#1111
  	
  sumCubes(2,4)                                   //> res1: Int#1111 = 99
  
  //sum of factorials of all integers between a and b
  def fact(x: Int): Int =
  	if (x == 0) 1 else x*fact(x-1)            //> fact: (x#204690: Int#1111)Int#1111
  	
  	
  def sumFact(a: Int, b: Int): Int =
  	if (a > b) 0 else fact(a) + sumFact(a+1,b)//> sumFact: (a#204696: Int#1111, b#204697: Int#1111)Int#1111
  	
  fact(3)                                         //> res2: Int#1111 = 6
  sumFact(1,3)                                    //> res3: Int#1111 = 9
  
  
  //Summing with Higher-Order functions
  // f is a paramter of sum function
  
  def sum(f: Int => Int, a: Int, b: Int): Int =
  	if (a>b) 0 else f(a) + sum(f,a+1,b)       //> sum: (f#204703: Int#1111 => Int#1111, a#204704: Int#1111, b#204705: Int#1111
                                                  //| )Int#1111
  	
  	
  def sumIntsHO(a: Int, b: Int) = sum(id, a, b)   //> sumIntsHO: (a#204712: Int#1111, b#204713: Int#1111)Int#1111
  def sumCubesHO(a: Int, b: Int) = sum(cube, a, b)//> sumCubesHO: (a#204717: Int#1111, b#204718: Int#1111)Int#1111
  def sumFactHO(a: Int, b: Int) = sum(fact, a, b) //> sumFactHO: (a#204721: Int#1111, b#204722: Int#1111)Int#1111
  
  def id(x: Int): Int = x                         //> id: (x#204714: Int#1111)Int#1111
  
  
  sumIntsHO(1,3)                                  //> res4: Int#1111 = 6
  sumCubesHO(1,3)                                 //> res5: Int#1111 = 36
  sumFactHO(1,3)                                  //> res6: Int#1111 = 9
  
  //Summing using anonymous functions
  
  def sumIntsAny(a: Int, b: Int) = sum(x=> x,a,b) //> sumIntsAny: (a#204725: Int#1111, b#204726: Int#1111)Int#1111
  sumIntsAny(2,3)                                 //> res7: Int#1111 = 5
  
  //Exercise: write tail recursive version of sum
  // unlike factorial, sum can actually profit from tail recursion
  // if distance between a and b is large, can lead to stack overflow
  def tailsum(f: Int => Int, a: Int, b: Int): Int = {
  
  	def loop(a: Int, acc: Int): Int = {
  		if (a == b) acc else loop(a+1, acc+f(a))
  	}
  	loop(a,f(b))
  }                                               //> tailsum: (f#204729: Int#1111 => Int#1111, a#204730: Int#1111, b#204731: Int
                                                  //| #1111)Int#1111
 
  
  	tailsum(fact,1,3)                         //> res8: Int#1111 = 9
  	tailsum(x=>x*x,3,5)                       //> res9: Int#1111 = 50
  	
  	
  	def oderskytailsum(f: Int => Int, a: Int, b: Int) = {
  		def loop(a:Int, acc: Int): Int =
  			if (a>b) acc
  			else loop(a+1, f(a) + acc)
  		loop(a,0)
  	}                                         //> oderskytailsum: (f#204747: Int#1111 => Int#1111, a#204748: Int#1111, b#2047
                                                  //| 49: Int#1111)Int#1111
  
  oderskytailsum(x=>x*x,3,5)                      //> res10: Int#1111 = 50
 		
 		
 		
}