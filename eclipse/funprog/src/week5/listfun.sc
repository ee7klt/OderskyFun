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
  }                                               //> pack: [T](xs: week5.List[T])week5.List[week5.List[T]]
  
  val lis = List("a","a","b","a","b")             //> lis  : List[String] = List(a, a, b, a, b)
  pack(lis).head.head                             //> res6: <error> = a
  
  
  //encode takes a list
  // returns run-length encoding of the list
  // List("a","a","b","b","b","a") -> List(("a",2),("b",3),("a",1))
  def encode[T](xs: List[T]): List[(T, Int)] = pack(xs).map(x => (x.head, x.length))
                                                  //> encode: [T](xs: week5.List[T])week5.List[(T, Int)]
  
  encode(lis)                                     //> res7: <error> = List((a,2), (b,1), (a,1), (b,1))
  
  
  // 5.5 reduction of lists
  
  def sum(xs: List[Double]): Double = xs match {
  	case List() => 0
  	case x::xs1 => x + sum(xs1)
  }                                               //> sum: (xs: week5.List[Double])Double
  
  
  sum(List(1,2,3))                                //> res8: <error> = 6.0
  
 def product(xs: List[Double]): Double = xs match {
  	case List() => 1
  	case x::xs1 => x * product(xs1)
  }                                               //> product: (xs: week5.List[Double])Double
  
  product(List(1,2,3))                            //> res9: <error> = 6.0
  
 def sumRed(xs: List[Double]): Double = 0.0::xs reduceLeft ((x,y) => x+y)
                                                  //> sumRed: (xs: week5.List[Double])Double
 sumRed(List(1,2,3))                              //> res10: <error> = 6.0
 sumRed(List())                                   //> res11: <error> = 0.0
 
 
 def concat[T](xs: List[T], ys: List[T]): List[T] =
   (xs foldRight ys)(_::_)                        //> concat: [T](xs: week5.List[T], ys: week5.List[T])week5.List[T]
}