package week1

object assignment1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def pascal(c: Int, r: Int): Int = {
    if (c == 0 && r == 0) 1 else {
      for (col <- 0 to 1) {
        if (col == 0 || col == c) 1 else { pascal(c - 1, r - 1) + pascal(c, r - 1) }
      }
      0
    }
  }                                               //> pascal: (c: Int, r: Int)Int

  pascal(2, 1)                                    //> java.lang.StackOverflowError
                                                  //| 	at scala.collection.AbstractIterable.<init>(Iterable.scala:54)
                                                  //| 	at scala.collection.AbstractSeq.<init>(Seq.scala:41)
                                                  //| 	at scala.collection.immutable.Range.<init>(Range.scala:62)
                                                  //| 	at scala.collection.immutable.Range$Inclusive.<init>(Range.scala:433)
                                                  //| 	at scala.collection.immutable.Range$.inclusive(Range.scala:455)
                                                  //| 	at scala.runtime.RichInt$.to$extension0(RichInt.scala:71)
                                                  //| 	at week1.assignment1$$anonfun$main$1.week1$assignment1$$anonfun$$pascal$
                                                  //| 1(week1.assignment1.scala:8)
                                                  //| 	at week1.assignment1$$anonfun$main$1$$anonfun$week1$assignment1$$anonfun
                                                  //| $$pascal$1$1.apply$mcII$sp(week1.assignment1.scala:9)
                                                  //| 	at week1.assignment1$$anonfun$main$1$$anonfun$week1$assignment1$$anonfun
                                                  //| $$pascal$1$1.apply(week1.assignment1.scala:8)
                                                  //| 	at week1.assignment1$$anonfun$main$1$$anonfun$week1$assignment1$$anonfun
                                                  //| $$pascal$1$1.apply(week1.assignment1.scala:8)
                                                  //| 	at scala.collection.immutable.Range.foreach(Range.scala:166)
}