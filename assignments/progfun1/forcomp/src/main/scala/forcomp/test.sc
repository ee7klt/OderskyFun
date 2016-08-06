import forcomp.Anagrams._

object test {
  wordOccurrences("hello")                        //> res0: forcomp.Anagrams.Occurrences = List((e,1), (h,1), (l,2), (o,1))

  val a = List("abc", "def")                      //> a  : List[String] = List(abc, def)
  for (
    x <- a
  ) yield a                                       //> res1: List[List[String]] = List(List(abc, def), List(abc, def))

  ("abc" + "def").toList                          //> res2: List[Char] = List(a, b, c, d, e, f)
  (a mkString ("")).toList                        //> res3: List[Char] = List(a, b, c, d, e, f)

  val capital = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capital  : scala.collection.immutable.Map[String,String] = Map(US -> Washing
                                                  //| ton, Switzerland -> Bern)
  capital("US")                                   //> res4: String = Washington
  capital get "US"                                //> res5: Option[String] = Some(Washington)

  val dic = Map(List(('a', 1), ('e', 1), ('t', 1)) -> Seq("ate", "eat", "tea"))
                                                  //> dic  : scala.collection.immutable.Map[List[(Char, Int)],Seq[String]] = Map(L
                                                  //| ist((a,1), (e,1), (t,1)) -> List(ate, eat, tea))
  dic(List(('a', 1), ('e', 1), ('t', 1)))         //> res6: Seq[String] = List(ate, eat, tea)
  (dic get List(('a', 1), ('e', 1), ('t', 1)))    //> res7: Option[Seq[String]] = Some(List(ate, eat, tea))
  (dic get List(('a', 1), ('e', 1), ('t', 1))) map (_.toSet)
                                                  //> res8: Option[scala.collection.immutable.Set[String]] = Some(Set(ate, eat, te
                                                  //| a))

  // combinations(List(('k', 1), ('o', 1)))
  // combinations(List())

  for (
    a <- List(1, 2, 3)
  ) yield a                                       //> res9: List[Int] = List(1, 2, 3)

  1 to 10                                         //> res10: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 
                                                  //| 7, 8, 9, 10)

  for (
    a <- 1 to 10
  ) yield List(a)                                 //> res11: scala.collection.immutable.IndexedSeq[List[Int]] = Vector(List(1), Li
                                                  //| st(2), List(3), List(4), List(5), List(6), List(7), List(8), List(9), List(1
                                                  //| 0))

  val l = List(('k', 2), ('o', 1))                //> l  : List[(Char, Int)] = List((k,2), (o,1))

  //def combi(o: Occurrences): List[Occurrences] = List(List())

  def combi(o: Occurrences): List[Occurrences] = {
    val ocs: List[Occurrences] = o.map(x => (for {
      i <- 1 to x._2
    } yield (x._1, i)).toList)
    ocs.foldRight(List[Occurrences](Nil))((x, y) => y ++ (for (i <- x; j <- y) yield (i :: j)))
  }                                               //> combi: (o: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Occurrences]

  combi(l)                                        //> res12: List[forcomp.Anagrams.Occurrences] = List(List(), List((o,1)), List(
                                                  //| (k,1)), List((k,1), (o,1)), List((k,2)), List((k,2), (o,1)))

  List(1, 2, 3) reduceLeft ((x, y) => x + y)      //> res13: Int = 6

  (List(1, 2, 3) foldLeft 1)(_ * _)               //> res14: Int = 6

  val k = List(List(('a', 1), ('a', 2), ('a', 3)), List(('k', 1), ('k', 2)), List(('o', 1)))
                                                  //> k  : List[List[(Char, Int)]] = List(List((a,1), (a,2), (a,3)), List((k,1), 
                                                  //| (k,2)), List((o,1)))

  val z = List(1, 2, 3)                           //> z  : List[Int] = List(1, 2, 3)
  // put each number in to its own list
  for (
    x <- z
  ) yield List(x)                                 //> res15: List[List[Int]] = List(List(1), List(2), List(3))

  def putinlist(x: List[Int]): List[List[Int]] = x match {
    case Nil     => Nil
    case x :: xs => List(x) :: putinlist(xs)
  }                                               //> putinlist: (x: List[Int])List[List[Int]]
  putinlist(z)                                    //> res16: List[List[Int]] = List(List(1), List(2), List(3))

  z map (x => List(x))                            //> res17: List[List[Int]] = List(List(1), List(2), List(3))

  //(z foldRight List())(_++_) // foldRight is xn op acc so this should work??

  1 :: List()                                     //> res18: List[Int] = List(1)

  def concat[T](xs: List[T], ys: List[T]): List[T] =
    (xs foldRight ys)(_ :: _)                     //> concat: [T](xs: List[T], ys: List[T])List[T]

  concat(z, List(4, 5, 6))                        //> res19: List[Int] = List(1, 2, 3, 4, 5, 6)
  concat(z, List())                               //> res20: List[Int] = List(1, 2, 3)

  // def myreduceRight[T](op: (T,T) => T): T = this match {
  //	case Nil => throw new Error ("Nil.reduceRight")
  //	case x::Nil => x
  //	case x::xs => op(x, xs.myreduceRight(op))
  //}

  // (z foldRight Nil) ((x,y) => List(x)::y)
  List(1) :: List()                               //> res21: List[List[Int]] = List(List(1))

  val x = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
                                                  //> x  : List[(Char, Int)] = List((a,1), (d,1), (l,1), (r,1))
  val y = List(('r', 1), ('a', 1))                //> y  : List[(Char, Int)] = List((r,1), (a,1))

  x map (
    x => for (
      (char, occ) <- y if (char == x._1)
    ) yield (x._1, x._2 - 1))                     //> res22: List[List[(Char, Int)]] = List(List((a,0)), List(), List(), List((r,
                                                  //| 0)))


  
  //
  
  
   
 List(1,2,3) partition (x => (x==1)||(x==2))      //> res23: (List[Int], List[Int]) = (List(1, 2),List(3))
 
 

	

  
  
  def adjust3(term: (Char, Int), terms: List[(Char, Int)]): List[(Char, Int)] = {
    terms filter (x => (term._1 == x._1))
  }                                               //> adjust3: (term: (Char, Int), terms: List[(Char, Int)])List[(Char, Int)]
  
    adjust3(('a', 1), List(('a', 2), ('b', 3))) == (a,1)
                                                  //> res24: Boolean = false
  //  adjust3(('c', 3), List(('a', 2), ('b', 3))) == (a,1)
  

  def adjust(term: (Char, Int), terms: List[(Char, Int)]): List[(Char, Int)] = {
    for (
      (ch, occ) <- terms
    ) yield {
      if (ch == term._1) (ch, occ - 1)
      else (ch, occ)
    }

  }                                               //> adjust: (term: (Char, Int), terms: List[(Char, Int)])List[(Char, Int)]



  def subt(x: List[(Char, Int)], y: List[(Char, Int)]): List[(Char, Int)] = y match {
  	case Nil => x
  	case p::ps =>  subt(adjust(p,x),ps)
  }                                               //> subt: (x: List[(Char, Int)], y: List[(Char, Int)])List[(Char, Int)]
  
  
  
  subt( List(('a', 2), ('b', 3)),List(('a', 1),('b',1)))
                                                  //> res25: List[(Char, Int)] = List((a,1), (b,2))
     
  def adjust2(term: (Char, Int), terms: List[(Char, Int)]): List[(Char, Int)] = terms map (
    (x) =>
      if (term._1 == x._1) (x._1, x._2 - 1)
      else x)                                     //> adjust2: (term: (Char, Int), terms: List[(Char, Int)])List[(Char, Int)]

  adjust(('a', 1), List(('a', 2), ('b', 3))) != List(('a', 1))
                                                  //> res26: Boolean = true
  adjust(('a', 1), List(('a', 2), ('b', 3))) == List(('a', 1), ('b', 3))
                                                  //> res27: Boolean = true
  adjust(('a', 1), List(('a', 2), ('b', 3)))      //> res28: List[(Char, Int)] = List((a,1), (b,3))

  adjust2(('a', 1), List(('a', 2), ('b', 3))) != List(('a', 1))
                                                  //> res29: Boolean = true
  adjust2(('a', 1), List(('a', 2), ('b', 3))) == List(('a', 1), ('b', 3))
                                                  //> res30: Boolean = true
  adjust2(('a', 1), List(('a', 2), ('b', 3)))     //> res31: List[(Char, Int)] = List((a,1), (b,3))

}