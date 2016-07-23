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
  
  
  
  
  def isSafe(col: Int, q: List[Int]): Boolean = {
  	val row = q.length // the very next row to place our queen
  	// transform q in to a List of pairs of form (row, column)
  	// right now q is a List of columns)
  	// the earlier elements of q are the latest queens to be put on the board
  	// so we're counting the rows from bottom up
  	// Martin: zip a range with the queens
  
  	val queensWithRow = (row-1 to 0 by -1) zip q
  	
  	// check to see if (col,row) is in check
  	// need to check previous col
  	// and diagonals
  	// use forall and pattern match
  	// for all the current queens on the board, do they all not threaten
  	// a new queen placed at (col, row)?
  	
  	queensWithRow forall {
  		case (r,c) =>
  			col != c && (row-r != math.abs(col-c))
  	}
  	
  
  }                                               //> isSafe: (col: Int, q: List[Int])Boolean
  
  isSafe(2, List(3,1))                            //> res0: Boolean = false
  isSafe(3, List(0,3,1))                          //> res1: Boolean = false
  9 to 0 by -1                                    //> res2: scala.collection.immutable.Range = Range(9, 8, 7, 6, 5, 4, 3, 2, 1, 0
                                                  //| )
  
}