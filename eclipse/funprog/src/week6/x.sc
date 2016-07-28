package week6

import scala.io.Source

object x {
  /* read a file of words */
  val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")
                                                  //> in  : scala.io.BufferedSource = non-empty iterator
  
  /* create a list and filter all words where *all* their characters are not letters (like dashes) */
  val words = in.getLines                         //> words  : Iterator[String] = non-empty iterator
  
  /* define the map of numbers to letters */
  val mnem = Map( '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")
                                                  //> mnem  : scala.collection.immutable.Map[Char,String] = Map(8 -> TUV, 4 -> GHI
                                                  //| , 9 -> WXYZ, 5 -> JKL, 6 -> MNO, 2 -> ABC, 7 -> PQRS, 3 -> DEF)
  
  /* invert the map the get a map of letters to digits */
  val charCode: Map[Char, Char] =
  for ((digit, str) <- mnem; ltr <- str) yield ltr -> digit
                                                  //> charCode  : Map[Char,Char] = Map(E -> 3, X -> 9, N -> 6, T -> 8, Y -> 9, J -
                                                  //| > 5, U -> 8, F -> 3, A -> 2, M -> 6, I -> 4, G -> 4, V -> 8, Q -> 7, L -> 5,
                                                  //|  B -> 2, P -> 7, C -> 2, H -> 4, W -> 9, K -> 5, R -> 7, O -> 6, D -> 3, Z -
                                                  //| > 9, S -> 7)
  
  /* define a function that returns the numbers of a given word */
  /** maps a word to the digit string it can represent e.g. "Java" -> "5282" */
  def wordCode(word: String): String =
  word.toUpperCase map charCode                   //> wordCode: (word: String)String
 /* for (
  	ltr <- word
  ) yield charCode(ltr)   */
  
  
  wordCode("Java")                                //> res0: String = 5282
  
  /* group all words of our long list with the same number */
  val wordsForNum: Map[String, Seq[String]] =  ???//> scala.NotImplementedError: an implementation is missing
                                                  //| 	at scala.Predef$.$qmark$qmark$qmark(Predef.scala:225)
                                                  //| 	at week6.x$$anonfun$main$1.apply$mcV$sp(week6.x.scala:31)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week6.x$.main(week6.x.scala:5)
                                                  //| 	at week6.x.main(week6.x.scala)
  /* function that receives a number and finds the words that match it */
  def encode(number: String): Set[List[String]] = ???
  /* better print of the results */
  def translate(number: String): Set[String] = ???
  /* test the translate and print results*/
  translate("7225247386") foreach println

}