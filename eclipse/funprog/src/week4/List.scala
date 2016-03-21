package week4


/**
 * @author macgeekalex
 */

// List is an immutable linked-list
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  
  
} 


// Cons is a cell containing an element
// and a pointer to the remainder of the list
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false // cons cells are never empty
}


// Nil is an empty list
class Nil[T] extends List[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head") // cannot take head of an empty list
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object List {
  // create List of length 2
  def apply[T](x1: T, x2:T): List[T] = new Cons(x1, new Cons(x2,new Nil))
  // create List of length 1
  def apply[T](x1:T) : List[T] = new Cons(x1, new Nil)
  // create empty list
  def apply[T]() : List[T] = new Nil
}





