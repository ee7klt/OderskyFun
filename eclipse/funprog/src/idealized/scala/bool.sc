package idealized.scala

object bool {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
   True.ifThenElse(False,True)                    //> res0: idealized.scala.Boolean = idealized.scala.False$@34ce8af7
   True && False                                  //> res1: idealized.scala.Boolean = idealized.scala.False$@34ce8af7
   True && True                                   //> res2: idealized.scala.Boolean = idealized.scala.True$@b684286
   
 //  (1 < 2) && False
}