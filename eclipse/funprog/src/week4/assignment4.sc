



object assignment4 {
 



/**
 * Assignment 4: Huffman coding
 *
 */

  val x = 2::"p"::"s"::Nil                        //> x  : List[Any] = List(2, p, s)
  val y = ('w',1)::Nil                            //> y  : List[(Char, Int)] = List((w,1))
  (3,2).getClass.getSimpleName                    //> res0: String = Tuple2$mcII$sp
 (3,2)._1                                         //> res1: Int = 3
 val tuple = ('a', 1)                             //> tuple  : (Char, Int) = (a,1)
   // destructuring baby!
val (char, digit) = tuple                         //> char  : Char = a
                                                  //| digit  : Int = 1
val numbers = List(1, 2, 3, 4)                    //> numbers  : List[Int] = List(1, 2, 3, 4)


 // numbers.filter((i: Int) => i % 2 == 0)
 
 
  def insert(x: Int, xs:List[Int]): List[Int] = xs match {
     case List() => List()
     case y::ys => {
       if (x < ys.head)  y::insert(x, ys.tail)
       // ys.head::Nil  // need someway of carrying around the accumulated head
       else ys.head::x::ys.tail
     }
	  
	 }                                        //> insert: (x: Int, xs: List[Int])List[Int]


def isort(xs: List[Int]): List[Int] = xs match {
	 case List() => List()
	 case y::ys => insert(y,isort(ys))
	 
	 
	 
}                                                 //> isort: (xs: List[Int])List[Int]

isort(List(3,5,1))                                //> res2: List[Int] = List()


  }