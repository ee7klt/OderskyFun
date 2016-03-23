package nat.scala

object Natural {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
   Zero;                                          //> res0: nat.scala.Zero.type = nat.scala.Zero$@34ce8af7
   val x = Zero.predecessor;                      //> java.lang.Error: 0.predecessor
                                                  //| 	at nat.scala.Zero$.predecessor(Nat.scala:26)
                                                  //| 	at nat.scala.Natural$$anonfun$main$1.apply$mcV$sp(nat.scala.Natural.scal
                                                  //| a:7)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at nat.scala.Natural$.main(nat.scala.Natural.scala:3)
                                                  //| 	at nat.scala.Natural.main(nat.scala.Natural.scala)
 
}