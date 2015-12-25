package week2



/**
 * 2. Purely Functional Sets.
 */
object assignment2 {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean
  
  
  def isPositive(x: Int): Boolean = {
  	if (x > 0) true else false
  }                                               //> isPositive: (x: Int)Boolean
  
  !isPositive(3)                                  //> res0: Boolean = false
  
  def isPositiveProduct(x: Int, y:Int => Boolean): Boolean = {
  	if ((x > 0) && y(9)) true
  	else false
  }                                               //> isPositiveProduct: (x: Int, y: Int => Boolean)Boolean
  
  
  

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: week2.assignment2.Set, elem: Int)Boolean

  contains((x: Int) => x < 0, -5)                 //> res1: Boolean = true
  
  
  /**
   * Returns the set of the one given element.
   */
    def singletonSet(elem: Int): Set = (x: Int) => x == elem
                                                  //> singletonSet: (elem: Int)week2.assignment2.Set
    def a = singletonSet(3)                       //> a: => week2.assignment2.Set
    a(4)                                          //> res2: Boolean = false
    a(3)                                          //> res3: Boolean = true
       val s1 = singletonSet(1)                   //> s1  : week2.assignment2.Set = <function1>
    val s2 = singletonSet(2)                      //> s2  : week2.assignment2.Set = <function1>
    val s3 = singletonSet(3)                      //> s3  : week2.assignment2.Set = <function1>
   contains(s1, 1)                                //> res4: Boolean = true

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
    def union(s: Set, t: Set): Set = (x: Int) => contains(s, x) || contains(t, x)
                                                  //> union: (s: week2.assignment2.Set, t: week2.assignment2.Set)week2.assignment
                                                  //| 2.Set
    def b = union((x: Int) => x < 0, (x:Int) => x%2 == 0)
                                                  //> b: => week2.assignment2.Set
     union((x: Int) => x < 0, (x:Int) => x%2 == 0)(9)
                                                  //> res5: Boolean = false
     b(4)                                         //> res6: Boolean = true
     b(-3)                                        //> res7: Boolean = true
     b(3)                                         //> res8: Boolean = false
  
  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
    def intersect(s: Set, t: Set): Set = (x:Int) => contains(s, x) && contains(t, x)
                                                  //> intersect: (s: week2.assignment2.Set, t: week2.assignment2.Set)week2.assign
                                                  //| ment2.Set
    def c = intersect((x: Int) => x < 0, (x:Int) => x%2 == 0)
                                                  //> c: => week2.assignment2.Set
     c(4)                                         //> res9: Boolean = false
     c(-4)                                        //> res10: Boolean = true
     c(-3)                                        //> res11: Boolean = false
     c(3)                                         //> res12: Boolean = false
  
  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
    def diff(s: Set, t: Set): Set = (x:Int) => (!contains(t, x)) && contains(s,x)
                                                  //> diff: (s: week2.assignment2.Set, t: week2.assignment2.Set)week2.assignment2
                                                  //| .Set
    def d = diff((x: Int) => x < 0, (x:Int) => x%2 == 0)
                                                  //> d: => week2.assignment2.Set
     d(4)                                         //> res13: Boolean = false
     d(-4)                                        //> res14: Boolean = false
     d(-3)                                        //> res15: Boolean = true
     d(3)                                         //> res16: Boolean = false
    
    
    
  /**
   * Returns the subset of `s` for which `p` holds.
   */
    def filter(s: Set, p: Int => Boolean): Set = (x:Int) => contains(s, x) && contains(p, x)
                                                  //> filter: (s: week2.assignment2.Set, p: Int => Boolean)week2.assignment2.Set
  

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 10                                  //> bound  : Int = 10

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
    def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
    	println(a, contains(s,a), contains(p,a))
    	
    	// if manage to reach end of bound without triggering a false from the
    	// next else statement, successfully passed p for all values of a in s
    	// within the bounds
      if (a > bound) true
      // if a is in s, but does not satisfy p, return false
      // does not return if
      // a is not in s, a is in s and satisfies p
      else if (contains(s,a) && !contains(p,a)) false
      // this a either still satifies p or is not in s
      // move on to the next a
      else iter(a+1)
    }
    iter(-bound)
  }                                               //> forall: (s: week2.assignment2.Set, p: Int => Boolean)Boolean
  
  
  def fil = filter((x: Int) => (x < 10), (x:Int) => (x% 2 == 0))
                                                  //> fil: => week2.assignment2.Set
  !fil(10)                                        //> res17: Boolean = true
  forall((x: Int) => (x < 10), (x:Int) => (x% 2 == 0))
                                                  //> (-10,true,true)
                                                  //| (-9,true,false)
                                                  //| res18: Boolean = false
                                                  
     forall((x: Int) => (x < 10 && x%4 ==0), (x:Int) => (x <= 100 && x%2 ==0 ))
                                                  //> (-10,false,true)
                                                  //| (-9,false,false)
                                                  //| (-8,true,true)
                                                  //| (-7,false,false)
                                                  //| (-6,false,true)
                                                  //| (-5,false,false)
                                                  //| (-4,true,true)
                                                  //| (-3,false,false)
                                                  //| (-2,false,true)
                                                  //| (-1,false,false)
                                                  //| (0,true,true)
                                                  //| (1,false,false)
                                                  //| (2,false,true)
                                                  //| (3,false,false)
                                                  //| (4,true,true)
                                                  //| (5,false,false)
                                                  //| (6,false,true)
                                                  //| (7,false,false)
                                                  //| (8,true,true)
                                                  //| (9,false,false)
                                                  //| (10,false,true)
                                                  //| (11,false,false)
                                                  //| res19: Boolean = true
  
  
  // are all integers in set S from [-1000,1000] divisible by 2?
 // forall((x: Int) => x < 0, (x:Int) => x%2 == 0)
  
  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
    def exists(s: Set, p: Int => Boolean): Boolean = {
    	!forall(s, !p(_))   // returns true if ALL members of s are outside p.
    	                   // that means no member of s is in p
    	                   // so shouldn't it return false? so negate it?
    }                                             //> exists: (s: week2.assignment2.Set, p: Int => Boolean)Boolean
  
  
  	// s = x is less than 0
  	// !p = is x less than or equal to -3?
  	
   exists( (x: Int) => x < -1, (x: Int) => x > -3)//> (-10,true,true)
                                                  //| (-9,true,true)
                                                  //| (-8,true,true)
                                                  //| (-7,true,true)
                                                  //| (-6,true,true)
                                                  //| (-5,true,true)
                                                  //| (-4,true,true)
                                                  //| (-3,true,true)
                                                  //| (-2,true,false)
                                                  //| res20: Boolean = true
                                                  
                                                 
  
  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
    def map(s: Set, f: Int => Int): Set =   {
  		
  		
  		// need to return a Set, which has signature (x:Int) => Boolean
  		// if x is equal to f(k), where k is an element of s, then return true.
  		// else false.
  		// thus if s is unbounded can only check for a limited number of f(k)'s.
  		//
  		// (x:Int) => contains(s, f(x)) && contains(s,x)
  		
  		
  		(x: Int) => {
  			//def a = singletonSet(f(x))
  			def iter(b: Int): Boolean = {
  				if (b > bound) false
  				else if (contains(s,b) && (f(b) == x)) true
  				else iter(b+1)
  			}
  			
  			iter(-bound)
  		}
  		
  		
  		}                                 //> map: (s: week2.assignment2.Set, f: Int => Int)week2.assignment2.Set
  	
  	
  	def mapper = map((x:Int) => x < -1, (x:Int) => x + 4)
                                                  //> mapper: => week2.assignment2.Set
  	mapper(3)                                 //> res21: Boolean = false
  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }                                               //> toString: (s: week2.assignment2.Set)String

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }                                               //> printSet: (s: week2.assignment2.Set)Unit
}