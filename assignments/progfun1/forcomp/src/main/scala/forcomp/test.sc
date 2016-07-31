import forcomp.Anagrams._

object test {
   wordOccurrences("hello")                       //> java.lang.ExceptionInInitializerError
                                                  //| 	at test$$anonfun$main$1.apply$mcV$sp(test.scala:4)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at test$.main(test.scala:3)
                                                  //| 	at test.main(test.scala)
                                                  //| Caused by: java.lang.RuntimeException: Could not load word list, dictionary f
                                                  //| ile not found
                                                  //| 	at scala.sys.package$.error(package.scala:27)
                                                  //| 	at forcomp.package$$anonfun$2.apply(package.scala:10)
                                                  //| 	at forcomp.package$$anonfun$2.apply(package.scala:10)
                                                  //| 	at scala.Option.getOrElse(Option.scala:121)
                                                  //| 	at forcomp.package$.loadDictionary(package.scala:9)
                                                  //| 	at forcomp.Anagrams$.<init>(Anagrams.scala:28)
                                                  //| 	at forcomp.Anagrams$.<clinit>(Anagrams.scala)
                                                  //| 	... 6 more
}