package week4

/**
 * @author macgeekalex
 */
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  
  
} 

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false // cons cells are never empty
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head") // cannot take head of an empty list
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}





