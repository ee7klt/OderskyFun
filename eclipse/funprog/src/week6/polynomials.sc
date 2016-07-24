package week6

object polynomials {
  class Poly(val terms: Map[Int, Double]) {
  	def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
  	def adjust(term: (Int,Double)): (Int,Double) = {
  		 (for {
  			(exp, coeff) <- terms
  			if (term._1) == exp
  		} yield (exp,term._2 + coeff)).head
  	}
  	override def toString = {
  		val lines =
  		for {
  			(exp,coeff) <- terms.toList.sorted.reverse
  		} yield coeff + "x^" + exp
  		lines mkString " + "
  	}
  }
  
  
  val p1 = new Poly(Map(1 -> 2.0, 3-> 4.0, 5 -> 6.2))
                                                  //> p1  : week6.polynomials.Poly = 6.2x^5 + 4.0x^3 + 2.0x^1
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))      //> p2  : week6.polynomials.Poly = 7.0x^3 + 3.0x^0
  p1 + p2                                         //> java.util.NoSuchElementException: next on empty iterator
                                                  //| 	at scala.collection.Iterator$$anon$2.next(Iterator.scala:39)
                                                  //| 	at scala.collection.Iterator$$anon$2.next(Iterator.scala:37)
                                                  //| 	at scala.collection.IterableLike$class.head(IterableLike.scala:107)
                                                  //| 	at scala.collection.AbstractIterable.head(Iterable.scala:54)
                                                  //| 	at week6.polynomials$Poly.adjust(week6.polynomials.scala:10)
                                                  //| 	at week6.polynomials$Poly$$anonfun$$plus$1.apply(week6.polynomials.scala
                                                  //| :5)
                                                  //| 	at week6.polynomials$Poly$$anonfun$$plus$1.apply(week6.polynomials.scala
                                                  //| :5)
                                                  //| 	at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike
                                                  //| .scala:245)
                                                  //| 	at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike
                                                  //| .scala:245)
                                                  //| 	at scala.collection.immutable.Map$Map2.foreach(Map.scala:137)
                                                  //| 	at scala.collection.TraversableLike$class.map(TraversableLike.scala:245)
                                                  //| 
                                                  //| 	at scala.collection.AbstractTraversable.map(Traversable.scala:104)
                                                  //| 	at week6.polyno
                                                  //| Output exceeds cutoff limit.
}