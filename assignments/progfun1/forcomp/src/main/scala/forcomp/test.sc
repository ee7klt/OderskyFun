import forcomp.Anagrams._

object test {
  wordOccurrences("hello") //> res0: forcomp.Anagrams.Occurrences = List((e,1), (h,1), (l,2), (o,1))

  val a = List("abc", "def") //> a  : List[String] = List(abc, def)
  for (
    x <- a
  ) yield a //> res1: List[List[String]] = List(List(abc, def), List(abc, def))

  ("abc" + "def").toList //> res2: List[Char] = List(a, b, c, d, e, f)
  (a mkString ("")).toList //> res3: List[Char] = List(a, b, c, d, e, f)

  val capital = Map("US" -> "Washington", "Switzerland" -> "Bern")
  //> capital  : scala.collection.immutable.Map[String,String] = Map(US -> Washing
  //| ton, Switzerland -> Bern)
  capital("US") //> res4: String = Washington
  capital get "US" //> res5: Option[String] = Some(Washington)

  val dic = Map(List(('a', 1), ('e', 1), ('t', 1)) -> Seq("ate", "eat", "tea"))
  //> dic  : scala.collection.immutable.Map[List[(Char, Int)],Seq[String]] = Map(L
  //| ist((a,1), (e,1), (t,1)) -> List(ate, eat, tea))
  dic(List(('a', 1), ('e', 1), ('t', 1))) //> res6: Seq[String] = List(ate, eat, tea)
  (dic get List(('a', 1), ('e', 1), ('t', 1))) //> res7: Option[Seq[String]] = Some(List(ate, eat, tea))
  (dic get List(('a', 1), ('e', 1), ('t', 1))) map (_.toSet)
  //> res8: Option[scala.collection.immutable.Set[String]] = Some(Set(ate, eat, te
  //| a))

}