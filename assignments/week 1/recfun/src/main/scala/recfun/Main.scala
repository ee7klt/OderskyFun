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
    def balance(chars: List[Char]): Boolean ={
    
    def check(counter: Int, chars: List[Char]): Int = {
      if (chars.isEmpty)
        {
        println(counter)
        counter
        }
      else {
          if (counter < 0) {
            println(counter)
            counter
            }
          else {
              val h = chars.head
              if (h == '(') {
                  println(counter)
                    println("Im at (")
                  check(counter+1, chars.tail)
            
                }
              else if (h == ')') {
                  println(counter)
                    println("Im at )")
                check(counter-1, chars.tail)
              }
              else check(counter, chars.tail)
              
            }
          }
    }
    
    check(0,chars) == 0
  } 

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0) 0
    else if (coins.length == 0) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
  

  
  
}
