

import week4._


// nth takes an integer n and a list and selects the nth
// element of the list.

object nth {
  def nth[T](n: Int, xs: List[T]): T =
  if (xs.isEmpty) throw new IndexOutOfBoundsException
  else if (n==0) xs.head
  else nth(n-1,xs.tail)                           //> nth: [T](n: Int, xs: week4.List[T])T
  
  // list = [1,2,3]
  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : week4.Cons[Int] = week4.Cons@34ce8af7
  nth(2,list)                                     //> res0: Int = 3
  nth(1,list)                                     //> res1: Int = 2
  nth(0,List(1,2))                                //> res2: Int = 1
  nth(1,List(1,2))                                //> res3: Int = 2
 // nth(3,List(1,2))
  nth(0,List(1))                                  //> res4: Int = 1
 // nth(0,List())
}