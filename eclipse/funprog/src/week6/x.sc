package week6

import scala.io.Source

object x {
  /* read a file of words */
  val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")
                                                  //> in  : scala.io.BufferedSource = non-empty iterator
  
  /* create a list and filter all words where *all* their characters are not letters (like dashes) */
  val words = in.getLines.toList filter (word => word forall (char => char.isLetter))
                                                  //> words  : List[String] = List(Aarhus, Aaron, Ababa, aback, abaft, abandon, ab
                                                  //| andoned, abandoning, abandonment, abandons, abase, abased, abasement, abasem
                                                  //| ents, abases, abash, abashed, abashes, abashing, abasing, abate, abated, aba
                                                  //| tement, abatements, abater, abates, abating, Abba, abbe, abbey, abbeys, abbo
                                                  //| t, abbots, Abbott, abbreviate, abbreviated, abbreviates, abbreviating, abbre
                                                  //| viation, abbreviations, Abby, abdomen, abdomens, abdominal, abduct, abducted
                                                  //| , abduction, abductions, abductor, abductors, abducts, Abe, abed, Abel, Abel
                                                  //| ian, Abelson, Aberdeen, Abernathy, aberrant, aberration, aberrations, abet, 
                                                  //| abets, abetted, abetter, abetting, abeyance, abhor, abhorred, abhorrent, abh
                                                  //| orrer, abhorring, abhors, abide, abided, abides, abiding, Abidjan, Abigail, 
                                                  //| Abilene, abilities, ability, abject, abjection, abjections, abjectly, abject
                                                  //| ness, abjure, abjured, abjures, abjuring, ablate, ablated, ablates, ablating
                                                  //| , ablation, ablative, ab
                                                  //| Output exceeds cutoff limit.
  
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
  /**
  * A map from digit strings to the words that represent them
  * e.g. "5282" -> List("Java", "Kata", "Lava", ... )
  * Note: a missing number should map to the empty set e.g. "1111" -> List()
  */
  
  val wordsForNum: Map[String, Seq[String]] = words groupBy wordCode
                                                  //> wordsForNum  : Map[String,Seq[String]] = Map(63972278 -> List(newscast), 29
                                                  //| 237638427 -> List(cybernetics), 782754448 -> List(starlight), 2559464 -> Li
                                                  //| st(allying), 862532733 -> List(uncleared), 365692259 -> List(enjoyably), 86
                                                  //| 8437 -> List(unties), 33767833 -> List(deportee), 742533 -> List(picked), 3
                                                  //| 364646489 -> List(femininity), 3987267346279 -> List(extraordinary), 785539
                                                  //| 7 -> List(pulleys), 67846493 -> List(optimize), 4723837 -> List(grafter), 3
                                                  //| 86583 -> List(evolve), 78475464 -> List(Stirling), 746459 -> List(singly), 
                                                  //| 847827 -> List(vistas), 546637737 -> List(lionesses), 28754283 -> List(curl
                                                  //| icue), 84863372658 -> List(thunderbolt), 46767833 -> List(imported), 264374
                                                  //| 64 -> List(angering, cohering), 8872267 -> List(turbans), 77665377 -> List(
                                                  //| spoolers), 46636233 -> List(homemade), 7446768759 -> List(rigorously), 7464
                                                  //| 4647 -> List(ringings), 633738 -> List(offset), 847825 -> List(visual), 772
                                                  //| 832 -> List(Pravda), 47
                                                  //| Output exceeds cutoff limit.
  	
  /* function that receives a number and finds the words that match it */
  /** return all ways to encode a number as a list of words */
  def encode(number: String): Set[List[String]] =
		if (number.isEmpty) Set(List())   // empty number represents an empty phrase, so don't put Set() here.
		else {for {
			split <- 1 to number.length
			word <- wordsForNum(number take split)
			rest <- encode(number drop split)
		} yield word::rest}.toSet         //> encode: (number: String)Set[List[String]]
		
		
encode("7225247386")                              //> java.util.NoSuchElementException: key not found: 7
                                                  //| 	at scala.collection.MapLike$class.default(MapLike.scala:228)
                                                  //| 	at scala.collection.AbstractMap.default(Map.scala:59)
                                                  //| 	at scala.collection.MapLike$class.apply(MapLike.scala:141)
                                                  //| 	at scala.collection.AbstractMap.apply(Map.scala:59)
                                                  //| 	at week6.x$$anonfun$main$1$$anonfun$week6$x$$anonfun$$encode$1$1.apply(w
                                                  //| eek6.x.scala:45)
                                                  //| 	at week6.x$$anonfun$main$1$$anonfun$week6$x$$anonfun$$encode$1$1.apply(w
                                                  //| eek6.x.scala:44)
                                                  //| 	at scala.collection.TraversableLike$$anonfun$flatMap$1.apply(Traversable
                                                  //| Like.scala:252)
                                                  //| 	at scala.collection.TraversableLike$$anonfun$flatMap$1.apply(Traversable
                                                  //| Like.scala:252)
                                                  //| 	at scala.collection.immutable.Range.foreach(Range.scala:166)
                                                  //| 	at scala.collection.TraversableLike$class.flatMap(TraversableLike.scala:
                                                  //| 252)
                                                  //| 	at scala.collection.AbstractTraversable.flatMap(Traversable.scala:104)
                                                  //| 	at week6.x$$anonfun$main$1.week6$x$$anonfun$$encode$1
                                                  //| Output exceeds cutoff limit.
  /* better print of the results */
  def translate(number: String): Set[String] = ???
  /* test the translate and print results*/
  translate("7225247386") foreach println

}