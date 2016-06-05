package week4

object decompositionPM {
  println("Welcome to the Scala worksheet")

  object Number {
    def apply(n: Int) = new Number(n)
  }

  val num1 = Number.apply(2)
  val num2 = Number.apply(3)

 val x = eval(Number(1))

}

class decompositionPM {
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr

  def eval(e: Expr): Int = e match {
    case Number(n)   => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
  }


    
}