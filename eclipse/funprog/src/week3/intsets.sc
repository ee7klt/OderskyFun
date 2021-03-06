package week3

object intsets {
  val t1 = new NonEmpty(3, new Empty, new Empty)  //> t1  : week3.NonEmpty = {.3.}
  val t2 = t1 incl 4                              //> t2  : week3.IntSet = {.3{.4.}}
  val t3 = t2 incl 1                              //> t3  : week3.IntSet = {{.1.}3{.4.}}
  val t4 = t3 incl 5                              //> t4  : week3.IntSet = {{.1.}3{.4{.5.}}}
  val t5 = new Empty                              //> t5  : week3.Empty = .
 val t6 = t5 union t4                             //> t6  : week3.IntSet = {{.1.}3{.4{.5.}}}
 val t7 = new NonEmpty(3,t2,t4)                   //> t7  : week3.NonEmpty = {{.3{.4.}}3{{.1.}3{.4{.5.}}}}
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  // does an empty set contain anything? no
  def contains(x: Int): Boolean = false
  
  // add x to an empty set.
  // this will result in a single node with empty sets
  // on either side of it.
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  
  // return a new set that is the result of
  // unioning the empty set with the set "other"
  // this should just return the set "other"
   def union(other: IntSet): IntSet = other
  
  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  override def toString = "{" + left + elem + right + "}"
  
    def union(other: IntSet): IntSet =
			((left union right) union other) incl elem
			
}