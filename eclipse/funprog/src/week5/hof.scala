package week5

/**
 * @author macgeekalex
 */
class hof {
  abstract class List[T] {
    
    
def map[U](f: T => U): List[U] = this match {
 // case Nil => this
 // case x::xs => f(x)::xs.map(f)

}
  }
}


