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

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: week2.assignment2.Set, elem: Int)Boolean

  contains((x: Int) => x < 0, -5)                 //> res0: Boolean = true
  
  
  /**
   * Returns the set of the one given element.
   */
    def singletonSet(elem: Int): Set = (x: Int) => x == elem
                                                  //> singletonSet: (elem: Int)week2.assignment2.Set
    def a = singletonSet(3)                       //> a: => week2.assignment2.Set
    a(4)                                          //> res1: Boolean = false
    a(3)                                          //> res2: Boolean = true
       val s1 = singletonSet(1)                   //> s1  : week2.assignment2.Set = <function1>
    val s2 = singletonSet(2)                      //> s2  : week2.assignment2.Set = <function1>
    val s3 = singletonSet(3)                      //> s3  : week2.assignment2.Set = <function1>
   contains(s1, 1)                                //> res3: Boolean = true

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
    def union(s: Set, t: Set): Set = (x: Int) => contains(s, x) || contains(t, x)
                                                  //> union: (s: week2.assignment2.Set, t: week2.assignment2.Set)week2.assignment2
                                                  //| .Set
    def b = union((x: Int) => x < 0, (x:Int) => x%2 == 0)
                                                  //> b: => week2.assignment2.Set
     b(4)                                         //> res4: Boolean = true
     b(-3)                                        //> res5: Boolean = true
     b(3)                                         //> res6: Boolean = false
  
  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
    def intersect(s: Set, t: Set): Set = (x:Int) => contains(s, x) && contains(t, x)
                                                  //> intersect: (s: week2.assignment2.Set, t: week2.assignment2.Set)week2.assign
                                                  //| ment2.Set
    def c = intersect((x: Int) => x < 0, (x:Int) => x%2 == 0)
                                                  //> c: => week2.assignment2.Set
     c(4)                                         //> res7: Boolean = false
     c(-4)                                        //> res8: Boolean = true
     c(-3)                                        //> res9: Boolean = false
     c(3)                                         //> res10: Boolean = false
  
  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
    def diff(s: Set, t: Set): Set = (x:Int) => (!contains(t, x)) && contains(s,x)
                                                  //> diff: (s: week2.assignment2.Set, t: week2.assignment2.Set)week2.assignment2
                                                  //| .Set
    def d = diff((x: Int) => x < 0, (x:Int) => x%2 == 0)
                                                  //> d: => week2.assignment2.Set
     d(4)                                         //> res11: Boolean = false
     d(-4)                                        //> res12: Boolean = false
     d(-3)                                        //> res13: Boolean = true
     d(3)                                         //> res14: Boolean = false
    
    
    
  /**
   * Returns the subset of `s` for which `p` holds.
   */
    def filter(s: Set, p: Int => Boolean): Set = (x:Int) => contains(s, x) && contains(p, x)
                                                  //> filter: (s: week2.assignment2.Set, p: Int => Boolean)week2.assignment2.Set
  

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000                                //> bound  : Int = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
    def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (???) ???
      else if (???) ???
      else iter(???)
    }
    iter(???)
  }                                               //> forall: (s: week2.assignment2.Set, p: Int => Boolean)Boolean
  
  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
    def exists(s: Set, p: Int => Boolean): Boolean = ???
                                                  //> exists: (s: week2.assignment2.Set, p: Int => Boolean)Boolean
  
  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
    def map(s: Set, f: Int => Int): Set = ???     //> map: (s: week2.assignment2.Set, f: Int => Int)week2.assignment2.Set
  
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