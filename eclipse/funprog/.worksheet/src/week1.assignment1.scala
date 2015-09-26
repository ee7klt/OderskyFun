package week1

object assignment1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  println("Welcome to the Scala worksheet");$skip(222); 

  def pascal(c: Int, r: Int): Int = {
  

    if (c == 0 && r == 0) 1 else {
        if (c == 0) 1 else {
        	if (r == 0) 0 else {
        	  pascal(c - 1, r - 1) + pascal(c, r - 1)
        	  }
        	}
    }
  };System.out.println("""pascal: (c: Int, r: Int)Int""");$skip(19); val res$0 = 
  

  pascal(2, 3);System.out.println("""res0: Int = """ + $show(res$0))}
}
