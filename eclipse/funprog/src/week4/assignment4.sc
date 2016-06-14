



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
     case List() => { // xs is empty
    // println("case 1")
    // 	println(x, xs)
     	x::Nil
     }
    // case y::Nil => {  // xs is a list of a single element
   //  println("case 2")
   //  println(x,xs)
   //  	if (x>y) List(y,x) else List(x,y)
   //  }
     case y::ys => {           // xs is a list of two or more elements
     //  println("case 3")
     //  println(x,xs)
       if (x > y)  {
     //  println("if clause")
       y::insert(x, ys)  // while x is more than(!) the first element of xs, move it up the list
       // CAUTION: the first element of xs is y, not ys.head!!
       }
       // ys.head::Nil  // need someway of carrying around the accumulated head
       else {  // we've found the first element in the list to which x is less. so we need to place x right before this element
     //  println("else clause")
       x::xs}
       
     }
	  
	 }                                        //> insert: (x: Int, xs: List[Int])List[Int]


def isort(xs: List[Int]): List[Int] = xs match {
	 case List() => List()
	 case y::ys => insert(y,isort(ys))
	 
	 
	 
}                                                 //> isort: (xs: List[Int])List[Int]

// test the if clause of case 3
isort(List(3,5,1))                                //> res2: List[Int] = List(1, 3, 5)
// test the else clause of case 3
isort(List(10,3,5,1))                             //> res3: List[Int] = List(1, 3, 5, 10)
                                                  
                                                  
 def times(chars: List[Char]): List[(Char, Int)] = chars match {
  case Nil => Nil   // no characters
  case x::xs => (x,1)::times(xs)
   }                                              //> times: (chars: List[Char])List[(Char, Int)]
  
  def helper(acc: List[(Char,Int)], c: Char):List[(Char,Int)] = {
  	
  	//val i = acc._1 indexOf c
     List(('a',1))
  }                                               //> helper: (acc: List[(Char, Int)], c: Char)List[(Char, Int)]
  
   
   times(List('a','b'))                           //> res4: List[(Char, Int)] = List((a,1), (b,1))
      
   val a = List(('a',1),('b',2))                  //> a  : List[(Char, Int)] = List((a,1), (b,2))
   a.filter(x => x._1 == 'a')                     //> res5: List[(Char, Int)] = List((a,1))
  }
  
  
  