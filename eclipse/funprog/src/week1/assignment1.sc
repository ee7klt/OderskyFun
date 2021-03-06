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
    if (c > r) throw new RuntimeException("c must be <= r") else helper(c, r)

  }                                               //> pascal: (c: Int, r: Int)Int

  pascal(2, 4)                                    //> res0: Int = 6

  def balance(chars: List[Char]): Boolean = {
    def go(cs: List[Char], level: Int): Boolean = cs match {
      case Nil                   => level == 0
      case ')' :: _ if level < 1 => false
      case ')' :: xs             => go(xs, level - 1)
      case '(' :: xs             => go(xs, level + 1)
      case _ :: xs               => go(xs, level)
    }
    go(chars, 0)
  }                                               //> balance: (chars: List[Char])Boolean

  balance(")(".toList)                            //> res1: Boolean = false
  
  
  def balance2(chars: List[Char]): Boolean = {
    def f(chars: List[Char], numOpens: Int): Boolean = {
      if (chars.isEmpty) {
        numOpens == 0
      } else {
        val h = chars.head
        val n =
          if (h == '(') numOpens + 1
          else if (h == ')') numOpens - 1
          else numOpens
        if (n >= 0) f(chars.tail, n)
        else false
      }
    }

    f(chars, 0)
  }                                               //> balance2: (chars: List[Char])Boolean
  balance2("()".toList)                           //> res2: Boolean = true
  
  /**
  countChars: counts number of characters in a string
  chars: string for which we wish to count characters
  check: helper function with counter variable to keep track of character numbers
  */
  def countChars(chars: List[Char]): Int ={
    def check(counter: Int, chars: List[Char]): Int = {
      if (chars.isEmpty) counter
      else check(counter+1, chars.tail)
    }
    
    check(0, chars)
  }                                               //> countChars: (chars: List[Char])Int
  countChars("hello world!".toList)               //> res3: Int = 12
  
  /**
  balance3: counts number of opening and closing parantheses pairs. if pairs balance, return true.
  but now it'll return true even if the parantheses are in the wrong order
  */
  def balance3(chars: List[Char]): Boolean ={
    
    def check(counter: Int, chars: List[Char]): Int = {
      if (chars.isEmpty) counter
      else {
       		val h = chars.head
   			 	if (h == "(") check(counter+1, chars.tail)
    			else if (h == ")") check(counter-1, chars.tail)
    			else check(counter, chars.tail)
    			}
    }
  	
  	check(0,chars) == 0
  }                                               //> balance3: (chars: List[Char])Boolean
  
  balance3(")(".toList)                           //> res4: Boolean = true
  
  
  def balance4(chars: List[Char]): Boolean ={
    
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
  }                                               //> balance4: (chars: List[Char])Boolean
  
  balance4("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList)
                                                  //> 0
                                                  //| Im at (
                                                  //| 1
                                                  //| Im at (
                                                  //| 2
                                                  //| Im at )
                                                  //| 1
                                                  //| Im at )
                                                  //| 0
                                                  //| Im at (
                                                  //| 1
                                                  //| Im at )
                                                  //| 0
                                                  //| res5: Boolean = true
                                                  
                                                  
                                                  
    def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0) 0
    else if (coins.length == 0) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }                                               //> countChange: (money: Int, coins: List[Int])Int
  
  countChange(100, List(1, 5, 10, 25, 50))        //> res6: Int = 292
  countChange(300,List(5,10,20,50,100,200,500))   //> res7: Int = 1022
  
}