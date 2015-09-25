package week1

object assignment1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  println("Welcome to the Scala worksheet");$skip(213); 

  def pascal(c: Int, r: Int): Int = {
    if (c == 0 && r == 0) 1 else {
      for (col <- 0 to 1) {
        if (col == 0 || col == c) 1 else { pascal(c - 1, r - 1) + pascal(c, r - 1) }
      }
      0
    }
  };System.out.println("""pascal: (c: Int, r: Int)Int""");$skip(16); val res$0 = 

  pascal(2, 1);System.out.println("""res0: Int = """ + $show(res$0))}
}
