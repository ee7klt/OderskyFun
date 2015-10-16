package week2

object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  //sum of all integers between a and b
  def sumInts(a: Int, b: Int): Int =
  	if (a > b) 0 else a + sumInts(a+1,b)      //> sumInts: (a#156987: Int#1111, b#156988: Int#1111)Int#1111
  
  sumInts(4,5)                                    //> res0: Int#1111 = 9
  
  def cube(x: Int): Int = x*x*x                   //> cube: (x#157236: Int#1111)Int#1111
  
  
  //sum of cubes of all integers between a and b
  def sumCubes(a: Int, b: Int): Int =
  	if (a > b) 0 else cube(a) + sumCubes(a+1,b)
                                                  //> sumCubes: (a#157240: Int#1111, b#157241: Int#1111)Int#1111
  	
  sumCubes(2,4)                                   //> res1: Int#1111 = 99
  
  //sum of factorials of all integers between a and b
  def fact(x: Int): Int =
  	if (x == 0) 1 else x*fact(x-1)            //> fact: (x#157247: Int#1111)Int#1111
  	
  	
  def sumFact(a: Int, b: Int): Int =
  	if (a > b) 0 else fact(a) + sumFact(a+1,b)//> sumFact: (a#157253: Int#1111, b#157254: Int#1111)Int#1111
  	
  fact(3)                                         //> res2: Int#1111 = 6
  sumFact(1,3)                                    //> res3: Int#1111 = 9
  
  
  //Summing with Higher-Order functions
  // f is a paramter of sum function
  
  def sum(f: Int => Int, a: Int, b: Int): Int =
  	if (a>b) 0 else f(a) + sum(f,a+1,b)       //> sum: (f#157260: Int#1111 => Int#1111, a#157261: Int#1111, b#157262: Int#1111
                                                  //| )Int#1111
  	
  	
  def sumIntsHO(a: Int, b: Int) = sum(id, a, b)   //> sumIntsHO: (a#157269: Int#1111, b#157270: Int#1111)Int#1111
  def sumCubesHO(a: Int, b: Int) = sum(cube, a, b)//> sumCubesHO: (a#157274: Int#1111, b#157275: Int#1111)Int#1111
  def sumFactHO(a: Int, b: Int) = sum(fact, a, b) //> sumFactHO: (a#157278: Int#1111, b#157279: Int#1111)Int#1111
  
  def id(x: Int): Int = x                         //> id: (x#157271: Int#1111)Int#1111
  
  
  sumIntsHO(1,3)                                  //> res4: Int#1111 = 6
  sumCubesHO(1,3)                                 //> res5: Int#1111 = 36
  sumFactHO(1,3)                                  //> res6: Int#1111 = 9
  
  //Summing using anonymous functions
  
  def sumIntsAny(a: Int, b: Int) = sum(x=> x,a,b) //> sumIntsAny: (a#157282: Int#1111, b#157283: Int#1111)Int#1111
  sumIntsAny(2,3)                                 //> res7: Int#1111 = 5
  
  //Exercise: write tail recursive version of sum
  // unlike factorial, sum can actually profit from tail recursion
  // if distance between a and b is large, can lead to stack overflow
  def tailsum(f: Int => Int, a: Int, b: Int): Int = {
  
  	def loop(x: Int, acc: Int): Int = {
  		if (x == 0) acc else loop(f(x-1), acc+f(x))
  	}
  	loop(a, f(b))
  }                                               //> tailsum: (f#157286: Int#1111 => Int#1111, a#157287: Int#1111, b#157288: Int
                                                  //| #1111)Int#1111
  
  def sumIntsTail(a: Int, b: Int) = tailsum(id, a, b)
                                                  //> sumIntsTail: (a#157298: Int#1111, b#157299: Int#1111)Int#1111
  def sumCubesTail(a: Int, b: Int) = tailsum(cube, a, b)
                                                  //> sumCubesTail: (a#157302: Int#1111, b#157303: Int#1111)Int#1111
  def sumFactTail(a: Int, b: Int) = tailsum(fact, a, b)
                                                  //> sumFactTail: (a#157306: Int#1111, b#157307: Int#1111)Int#1111
  
  
    sumIntsTail(1,3)                              //> res8: Int#1111 = 4
  	sumCubesTail(1,3)                         //> res9: Int#1111 = 28\
 		sumFactTail(1,3)
}