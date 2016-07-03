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
  
  
  def pack[T](xs: List[T]): List[List[T]] = xs match {
  	case List() => List()
  	case x::xs1 => (xs filter (y => y == x)) :: pack(xs filterNot (y => y == x))
  }                                               //> pack: [T](xs: List[T])List[List[T]]
  
  val lis = List("a","a","b","a","b")             //> lis  : List[String] = List(a, a, b, a, b)
  pack(lis)                                       //> res6: List[List[String]] = List(List(a, a, a), List(b, b))
  
}