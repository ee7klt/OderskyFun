import forcomp.Anagrams._

object test {
  wordOccurrences("hello")

  val a = List("abc", "def")
  for (
    x <- a
  ) yield a

  ("abc" + "def").toList
  (a mkString ("")).toList

  val capital = Map("US" -> "Washington", "Switzerland" -> "Bern")
  capital("US")
  capital get "US"

  val dic = Map(List(('a', 1), ('e', 1), ('t', 1)) -> Seq("ate", "eat", "tea"))
  dic(List(('a', 1), ('e', 1), ('t', 1)))
  (dic get List(('a', 1), ('e', 1), ('t', 1)))
  (dic get List(('a', 1), ('e', 1), ('t', 1))) map (_.toSet)

  // combinations(List(('k', 1), ('o', 1)))
  // combinations(List())

  for (
    a <- List(1, 2, 3)
  ) yield a

  1 to 10

  for (
    a <- 1 to 10
  ) yield List(a)

  val l = List(('k', 2), ('o', 1))

  //def combi(o: Occurrences): List[Occurrences] = List(List())

  def combi(o: Occurrences): List[Occurrences] = {
    val ocs: List[Occurrences] = o.map(x => (for {
      i <- 1 to x._2
    } yield (x._1, i)).toList)
    ocs.foldRight(List[Occurrences](Nil))((x, y) => y ++ (for (i <- x; j <- y) yield (i :: j)))
  }

  combi(l)

  List(1, 2, 3) reduceLeft ((x, y) => x + y)

  (List(1, 2, 3) foldLeft 1)(_ * _)

  val k = List(List(('a', 1), ('a', 2), ('a', 3)), List(('k', 1), ('k', 2)), List(('o', 1)))

  val z = List(1, 2, 3)
  // put each number in to its own list
  for (
    x <- z
  ) yield List(x)

  def putinlist(x: List[Int]): List[List[Int]] = x match {
    case Nil     => Nil
    case x :: xs => List(x) :: putinlist(xs)
  }
  putinlist(z)

  z map (x => List(x))

  //(z foldRight List())(_++_) // foldRight is xn op acc so this should work??

  1 :: List()

  def concat[T](xs: List[T], ys: List[T]): List[T] =
    (xs foldRight ys)(_ :: _)

  concat(z, List(4, 5, 6))
  concat(z, List())

  // def myreduceRight[T](op: (T,T) => T): T = this match {
  //	case Nil => throw new Error ("Nil.reduceRight")
  //	case x::Nil => x
  //	case x::xs => op(x, xs.myreduceRight(op))
  //}

  // (z foldRight Nil) ((x,y) => List(x)::y)
  List(1) :: List()

  val x = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
  val y = List(('r', 1), ('a', 1))

  x map (
    x => for (
      (char, occ) <- y if (char == x._1)
    ) yield (x._1, x._2 - 1))

  //
  // expect the extraction of element x at index 1 to be ('d',1)
  (x apply 1) == ('d', 1)

  // occurrence of 'd' should be 1
  x.toMap.apply('d') == 1
  // x.toMap('d') why does this not work?

  //expect tuple for 'p' occurrence to be at index position 3
  x.indexWhere(p => p._1 == 'r') == 3

  // expect position of 'r' in x to be at index 3
  x.indexWhere(p => p._1 == y(0)._1) == 3

  // expect the updated occurrence of 'r' to be 0
  val n = x.indexWhere(p => p._1 == y(0)._1)
  (x updated (n, (x(n)._1, x(n)._2 - y(0)._2))) == List(('a', 1), ('d', 1), ('l', 1), ('r', 0))

  (y foldLeft x)(
    (acc, next_y) => {
      val n = acc.indexWhere(p => p._1 == next_y._1)
      (acc updated (n, (acc(n)._1, acc(n)._2 - next_y._2)))
    })

  List(1, 2, 3) partition (x => (x == 1) || (x == 2))

  def adjust3(term: (Char, Int), terms: List[(Char, Int)]): List[(Char, Int)] = {
    terms filter (x => (term._1 == x._1))
  }

  adjust3(('a', 1), List(('a', 2), ('b', 3))) == (a, 1)
  //  adjust3(('c', 3), List(('a', 2), ('b', 3))) == (a,1)

  def adjust(term: (Char, Int), terms: List[(Char, Int)]): List[(Char, Int)] = {
    for (
      (ch, occ) <- terms
    ) yield {
      if (ch == term._1) (ch, occ - term._2)
      else (ch, occ)
    }

  }

  def subt(x: List[(Char, Int)], y: List[(Char, Int)]): List[(Char, Int)] = y match {
    case Nil     => x
    case p :: ps => subt(adjust(p, x), ps)
  }

  subt(List(('a', 2), ('b', 3)), List(('a', 1), ('b', 1)))
  subt(List(('a', 2), ('b', 3)), List(('a', 1), ('b', 3)))

  def adjust2(term: (Char, Int), terms: List[(Char, Int)]): List[(Char, Int)] = terms map (
    (x) =>
      if (term._1 == x._1) (x._1, x._2 - 1)
      else x)

  adjust(('a', 1), List(('a', 2), ('b', 3))) != List(('a', 1))
  adjust(('a', 1), List(('a', 2), ('b', 3))) == List(('a', 1), ('b', 3))
  adjust(('a', 1), List(('a', 2), ('b', 3)))

  adjust2(('a', 1), List(('a', 2), ('b', 3))) != List(('a', 1))
  adjust2(('a', 1), List(('a', 2), ('b', 3))) == List(('a', 1), ('b', 3))
  adjust2(('a', 1), List(('a', 2), ('b', 3)))

  List(List(1), List(2))

  val s = List("you", "I", "love")
  val so = sentenceOccurrences(s)
  val combos = combinations(so)
  combos apply 15

  dictionaryByOccurrences.get(List(('a', 1), ('e', 1), ('t', 1)))

  val w = (for (
    x <- combos
  ) yield dictionaryByOccurrences.get(x)) filter (x => x != None)

  // helper takes sentenceoccurrence and occurence from combo, subtracts occurrence from sentenceoccurrence
  // and returns dictionary words for that occurrence
  // store these words in a List?
  // have to do this recursively
  // pass in subtract(SO, O) to the function again
  // oh darn! this is exactly a fold application!
  // the accumulator is where i store these words,
  // and the operation being folded in to is subtract yes?
  // maybe not ..

  combos.map(x => {

  })

  // helper function takes a combo, and subtracts that combo from sentenceOccurrences
  // don't actually need this, subtract is enough
  // def subtractFromSentence(s: Sentence, c: Occurrences):Sentence = ???

  wordAnagrams("set")

  dictionaryByOccurrences.get(List(('a', 1), ('e', 1), ('t', 1)))
  dictionaryByOccurrences(List(('a', 1), ('e', 1), ('t', 1)))
  dictionaryByOccurrences.get(List(('z',1)))

  def validWords(occ: Occurrences): List[Word] = {
    dictionaryByOccurrences.get(occ) match {
      case Some(l) => l
      case None    => List(List())
    }
  }
  
  def help(l: List[Word]): List[Word] = {
  	if (l.isEmpty) List(List())
  	else l
  }

  validWords(List(('a', 1), ('e', 1), ('t', 1)))
  validWords(List())
}