package week1

object assignment1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def pascal(c: Int, r: Int): Int = {
  

    if (c == 0 && r == 0) 1 else {
        if (c == 0) 1 else {
        	if (r == 0) 0 else {
        	  pascal(c - 1, r - 1) + pascal(c, r - 1)
        	  }
        	}
    }
  }                                               //> pascal: (c: Int, r: Int)Int
  

  pascal(2, 3)                                    //> res0: Int = 3
}