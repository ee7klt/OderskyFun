package nat.scala

object Natural {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
   Zero;                                          //> res0: nat.scala.Zero.type = nat.scala.Zero$@34ce8af7
   val x = new Succ(Zero); // 1                   //> x  : nat.scala.Succ = nat.scala.Succ@b684286
   val y = x.successor;    // 2                   //> y  : nat.scala.Nat = nat.scala.Succ@880ec60
   val z = x + y;           // 3                  //> z  : nat.scala.Nat = nat.scala.Succ@3f3afe78
   val a = y -  x;                                //> a  : nat.scala.Nat = nat.scala.Succ@b684286
   
   
}