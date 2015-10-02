package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {

    def helper(c: Int, r: Int): Int = {
      if (c == 0 && r == 0) 1 else {
        if (c == 0) 1 else {
          if (r == 0) 0 else {
            helper(c - 1, r - 1) + helper(c, r - 1)
          }
        }
      }
    }
    if (c>r) throw new RuntimeException("c must be <= r") else  helper(c,r)
   

  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    
    def checkChar(ch:Char, c:Int):Int = 
      if (ch == '(') c+1 else if (c==')') c-1 else c
      
    def loop(iChars:List[Char], state:Int):Int= {
        if (iChars.isEmpty) state
        else if (state == -1) -1
        else loop(iChars.tail,(checkChar(iChars.head,state)))
      }
    
    if (loop(chars,0) == 0) true else false
    
    
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = 0
}
