package funsets


/**
 * 2. Purely Functional Sets.
 */
object FunSets {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  /**
   * Returns the set of the one given element.
   */
    def singletonSet(elem: Int): Set = {
      (x: Int) => x == elem
     /** def f(e: Int): Boolean ={
       if (e == elem) return true
       else return false
     }
     return f */
  }
  

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
    def union(s: Set, t: Set): Set = {
      (x:Int) => {
      /**  println(x)
        println(s)
        println(t)
        println(contains(s,x))
        println(contains(t,x)) */
        (contains(s,x) || contains(t,x))
      }
    }
    
  
  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
    def intersect(s: Set, t: Set): Set = (x:Int) => contains(s,x) && contains(t,x)
  
  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
    def diff(s: Set, t: Set): Set = (x:Int) => contains(s,x) && !contains(t,x)
  
  /**
   * Returns the subset of `s` for which `p` holds.
   */
    def filter(s: Set, p: Int => Boolean): Set = (x:Int) => contains(s,x) && p(x)
  

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   * tests whether a given predicate is true for all elements of the set.
   */
    def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound)  true
      else if (contains(s,a) && !contains(p,a))  false
      else iter(a+1)
    }
    iter(-bound)
  }
  
  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   * tests whether a set contains at least one element for which the given predicate is true.
   */
    def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, !p(_))
  
  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   * for a given value x, there exists some value p from s such that f(p) == x 
   */
    def map(s: Set, f: Int => Int): Set = (x:Int) => exists(s, (p:Int) => f(p) == x)
  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }
}
