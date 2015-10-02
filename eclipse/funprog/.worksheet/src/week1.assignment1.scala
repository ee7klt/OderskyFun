package week1

object assignment1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  println("Welcome to the Scala worksheet");$skip(348); 

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

  };System.out.println("""pascal: (c: Int, r: Int)Int""");$skip(16); val res$0 = 

  pascal(2, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(382); 

  def balance(chars: List[Char]): Boolean = {
    def go(cs: List[Char], level: Int): Boolean = cs match {
      case Nil                   => level == 0
      case ')' :: _ if level < 1 => false
      case ')' :: xs             => go(xs, level - 1)
      case '(' :: xs             => go(xs, level + 1)
      case _ :: xs               => go(xs, level)
    }
    go(chars, 0)
  };System.out.println("""balance: (chars: List[Char])Boolean""");$skip(24); val res$1 = 

  balance(")(".toList);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(411); 
  
  
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
  };System.out.println("""balance2: (chars: List[Char])Boolean""");$skip(24); val res$2 = 
  balance2("()".toList);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(412); 
  
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
  };System.out.println("""countChars: (chars: List[Char])Int""");$skip(36); val res$3 = 
  countChars("hello world!".toList);System.out.println("""res3: Int = """ + $show(res$3));$skip(560); 
  
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
  };System.out.println("""balance3: (chars: List[Char])Boolean""");$skip(27); val res$4 = 
  
  balance3(")(".toList);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(731); 
  
  
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
  };System.out.println("""balance4: (chars: List[Char])Boolean""");$skip(89); val res$5 = 
  
  balance4("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList);System.out.println("""res5: Boolean = """ + $show(res$5))}
  
}
