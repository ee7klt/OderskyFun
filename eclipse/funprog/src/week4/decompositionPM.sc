package week4

object decompositionPM {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr


  def eval(e: Expr): Int = e match {
    case Number(n)   => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
    
  }                                               //> eval: (e: week4.decompositionPM.Expr)Int

def show(e: Expr): String = e match {
     case Number(n) => n.toString
   	case Sum(e1,e2) => e1 match {
    	case Number(x) =>	show(e1) + " + " + show(e2)
   	}
}                                                 //> show: (e: week4.decompositionPM.Expr)String
  

 val x = eval(Number(1))                          //> x  : Int = 1
val y =show(Number(1))                            //> y  : String = 1
val z= show(Sum(Number(2),Number(3)))             //> z  : String = 2 + 3


}