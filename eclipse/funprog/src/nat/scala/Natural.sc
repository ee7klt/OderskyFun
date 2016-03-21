package nat.scala

object Natural {
  println("Welcome to the Scala worksheet")
  
  val z = Zero;
  val a =  new Succ(z);
  val b = new Succ(a);
  b+a
 
}