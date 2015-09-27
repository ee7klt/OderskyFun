package week1

object assignment1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

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
   

  }                                               //> pascal: (c: Int, r: Int)Int
  

  pascal(2, 4)                                    //> res0: Int = 6
}