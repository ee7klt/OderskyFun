package week6

object scratch {
  val xs = Array(1,2,3,44)                        //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (x => x *2)                              //> res0: Array[Int] = Array(2, 4, 6, 88)
  
  val s = "Hello World"                           //> s  : String = Hello World
  s filter (c => c.isUpper)                       //> res1: String = HW
  
  val r: Range = 1 until 5                        //> r  : Range = Range(1, 2, 3, 4)
  val d: Range = 1 to 5                           //> d  : Range = Range(1, 2, 3, 4, 5)
  
  1 to 10 by 3                                    //> res2: scala.collection.immutable.Range = Range(1, 4, 7, 10)
  6 to 1 by -2                                    //> res3: scala.collection.immutable.Range = Range(6, 4, 2)
  
  
  s exists (c => c.isUpper)                       //> res4: Boolean = true
  s forall (c => c.isUpper)                       //> res5: Boolean = false
  
  val pairs = List(1,2,3) zip s                   //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  pairs.unzip                                     //> res6: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
  
  
  // flatMap differs from map because it concatenates the results
  // map only would have returned a list of lists of .c here
  s flatMap(c => List('.', c))                    //> res7: String = .H.e.l.l.o. .W.o.r.l.d
  xs.sum                                          //> res8: Int = 50
  xs.max                                          //> res9: Int = 44
  //(1,2).product
  
  (1 to 2) flatMap (x => List(x))                 //> res10: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2)
   (1 to 2) flatMap (x => (3 to 4) map (y => List(x,y)))
                                                  //> res11: scala.collection.immutable.IndexedSeq[List[Int]] = Vector(List(1, 3),
                                                  //|  List(1, 4), List(2, 3), List(2, 4))
   List(1,2).product                              //> res12: Int = 2
  
   
  ( Vector(1,2) zip Vector(2,3) )                 //> res13: scala.collection.immutable.Vector[(Int, Int)] = Vector((1,2), (2,3))

  Vector(1,2).product                             //> res14: Int = 2
   
   def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
     ((xs zip ys) map (x => x._1 * x._2)).sum     //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double
     
   scalarProduct(Vector(1,2,3), Vector(2,3,4))    //> res15: Double = 20.0
   
     def scalarProductPM(xs: Vector[Double], ys: Vector[Double]): Double =
     ((xs zip ys) map{case (a,b) => a*b}).sum     //> scalarProductPM: (xs: Vector[Double], ys: Vector[Double])Double
    scalarProductPM(Vector(1,2,3), Vector(2,3,4)) //> res16: Double = 20.0
    
    
    
    def isPrime(n: Int): Boolean =
    	(2 until n) forall (d => d%n !=0)         //> isPrime: (n: Int)Boolean
    	//((1 to n) filter (x => n%x == 0)).length == 2
    	//!((2 to n-1) exists (x => n%x == 0))
    
    isPrime(1)                                    //> res17: Boolean = true
     
     
     
     
}