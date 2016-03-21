package idealized.scala

/**
 * @author macgeekalex
 */
abstract class Boolean {
  def ifThenElse[T](t: => T, e: => T): T
  def && (x: => Boolean): Boolean = ifThenElse(x, False)
  def < (x: => Boolean):Boolean = ifThenElse(False, x)
}

object True extends Boolean {
  def ifThenElse[T](t: => T, e: => T): T = t
}

object False extends Boolean {
  def ifThenElse[T](t: => T, e: => T): T = e
}

//class Bool extends Boolean {
//  def ifThenElse[T](t: => T, e: => T): T = if this t else e
//}


