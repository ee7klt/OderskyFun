package week4

object decomposition {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val num1 = new Number(3)                        //> num1  : week4.Number = week4.Number@34ce8af7
  val num2 = new Number(2)                        //> num2  : week4.Number = week4.Number@b684286
  num1.isNumber                                   //> res0: Boolean = true
  num1.isSum                                      //> res1: Boolean = false
  num1.numValue                                   //> res2: Int = 3
 // num.leftOp
  def eval(e: Expr): Int = {
  if (e.isNumber) e.numValue
  else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
  else throw new Error("Unknown expression" + e)
}                                                 //> eval: (e: week4.Expr)Int


val mysum = new Sum(num1,num2)                    //> mysum  : week4.Sum = week4.Sum@880ec60
 val myeval = eval(mysum)                         //> myeval  : Int = 5
  
}