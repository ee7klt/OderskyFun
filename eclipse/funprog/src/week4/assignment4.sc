



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
  case x::xs => iterChars(chars)
   }                                              //> times: (chars: List[Char])List[(Char, Int)]
  
  
  def iterChars(chars: List[Char]): List[(Char, Int)] = chars match {
    case List() => List()
    case x::xs => helper(iterChars(xs), x)
  }                                               //> iterChars: (chars: List[Char])List[(Char, Int)]
  
  def helper(acc: List[(Char,Int)], c: Char):List[(Char,Int)] = acc match {
  	
  	//val i = acc._1 indexOf c
    case List() => (c,1)::Nil
    case x::xs => if (x._1 == c) (x._1, x._2+1)::xs else x::helper(xs, c)

  }                                               //> helper: (acc: List[(Char, Int)], c: Char)List[(Char, Int)]
  
   val a = List(('a',1),('b',2))                  //> a  : List[(Char, Int)] = List((a,1), (b,2))
  val b = List('a','b','b','c','a')               //> b  : List[Char] = List(a, b, b, c, a)
  helper(a, 'd')                                  //> res4: List[(Char, Int)] = List((a,1), (b,2), (d,1))
  helper(a, 'a')                                  //> res5: List[(Char, Int)] = List((a,2), (b,2))
  helper(a,'b')                                   //> res6: List[(Char, Int)] = List((a,1), (b,3))
  
  iterChars(b)                                    //> res7: List[(Char, Int)] = List((a,2), (c,1), (b,2))
  
  
     a.filter(x => x._1 == 'a')                   //> res8: List[(Char, Int)] = List((a,1))
   a.map(x => (x._1,x._2+1))                      //> res9: List[(Char, Int)] = List((a,2), (b,3))
   
      times(b)                                    //> res10: List[(Char, Int)] = List((a,2), (c,1), (b,2))
      
      
      
      case class User(name: String, age: Int)
      val fred = User("fred", 32)                 //> fred  : assignment4.User = User(fred,32)
      val wilma = User("wilma", 29)               //> wilma  : assignment4.User = User(wilma,29)
      val betty = User("betty", 21)               //> betty  : assignment4.User = User(betty,21)
      val users = List(wilma, betty, fred)        //> users  : List[assignment4.User] = List(User(wilma,29), User(betty,21), User
                                                  //| (fred,32))
      val sorted = users.sorted(Ordering.by((_: User).age))
                                                  //> sorted  : List[assignment4.User] = List(User(betty,21), User(wilma,29), Use
                                                  //| r(fred,32))
      val sorted2 = users.sortBy(_.age)           //> sorted2  : List[assignment4.User] = List(User(betty,21), User(wilma,29), Us
                                                  //| er(fred,32))
  }
  
  
  