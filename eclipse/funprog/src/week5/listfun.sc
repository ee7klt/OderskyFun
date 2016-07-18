package week5

object listfun {
  val nums = List(2,-4,5,7,1)                     //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  val fruits = List("apple","pineapple","orange","banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
  
  nums filter (x => x >0)                         //> res0: List[Int] = List(2, 5, 7, 1)
  nums filterNot (x => x > 0)                     //> res1: List[Int] = List(-4)
  nums partition (x => x > 0)                     //> res2: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))
  nums takeWhile (x => x > 0)                     //> res3: List[Int] = List(2)
  nums dropWhile (x => x > 0)                     //> res4: List[Int] = List(-4, 5, 7, 1)
  nums span (x => x > 0)                          //> res5: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))
  
  // pack takes a List
  // packs consecutive duplicates of the list elements into sublists
  //  List("a","a","b","b","b","a") -> List(List("a","a"),List("b","b","b"),List("a"))
  def pack[T](xs: List[T]): List[List[T]] = xs match {
  	case List() => List()
  	case x::xs1 => {
  		val (a,b) = (xs span (y => y == x))
  		a :: pack(b)
  	}
  	
  	//(xs filter (y => y == x)) :: pack(xs filterNot (y => y == x))
  }                                               //> pack: [T](xs: List[T])List[List[T]]
  
  val lis = List("a","a","b","a","b")             //> lis  : List[String] = List(a, a, b, a, b)
  pack(lis).head.head                             //> res6: String = a
  
  
  //encode takes a list
  // returns run-length encoding of the list
  // List("a","a","b","b","b","a") -> List(("a",2),("b",3),("a",1))
  def encode[T](xs: List[T]): List[(T, Int)] = pack(xs).map(x => (x.head, x.length))
                                                  //> encode: [T](xs: List[T])List[(T, Int)]
  
  encode(lis)                                     //> res7: List[(String, Int)] = List((a,2), (b,1), (a,1), (b,1))
}