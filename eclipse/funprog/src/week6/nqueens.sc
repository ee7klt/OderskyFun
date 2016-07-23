package week6

object nqueens {
  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int):Set[List[Int]] =
    	if (k == 0) Set(List())
    	else
    		for {
    			queens <- placeQueens(k-1)
    			col <- 0 until n
    			if isSafe(col, queens)
    		} yield col::queens
    placeQueens(n)
  }                                               //> queens: (n: Int)Set[List[Int]]
  
  // is it safe to put a queen on column n of the next available row?
  // the next available row is of course queens.length
  // we are filling the queens row-wise, starting from top row to the bottom row
  // we thus need to check that there are no queens in the particular column we want to place
  // hence the condition that n should not be equal to x
  // but how to check the condition that there are no threats diagonally?
  // only need to look along the top left and top right diagonal since there won't be any queens on the rows below
  // sufficient to check only the immediate top-left and top-right box?
  
  
  
  
  def isSafe(n: Int, q: List[Int]): Boolean = {
  	val row = q.length // the very next row to place our queen
  	// transform q in to a List of pairs of form (row, column)
  	// right now q is a List of columns)
  	val coords = q map (x => (row, x))
  	
  	
  	(for {
  		x <- q
  		if n != x
  	} yield true) forall (y => true)
  
  }                                               //> isSafe: (n: Int, q: List[Int])Boolean
  
  isSafe(0, List(3,1))                            //> res0: Boolean = true
  isSafe(3, List(0,3,1))                          //> res1: Boolean = true
  
  
}