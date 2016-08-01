import forcomp.Anagrams._

object test {
   wordOccurrences("hello")                       //> res0: forcomp.Anagrams.Occurrences = List((e,1), (h,1), (l,2), (o,1))
        
        
        val a = List("abc","def")                 //> a  : List[String] = List(abc, def)
        for (
        	x <- a
        )yield a                                  //> res1: List[List[String]] = List(List(abc, def), List(abc, def))
        
        ("abc"+"def").toList                      //> res2: List[Char] = List(a, b, c, d, e, f)
        (a mkString ("")).toList                  //> res3: List[Char] = List(a, b, c, d, e, f)
}