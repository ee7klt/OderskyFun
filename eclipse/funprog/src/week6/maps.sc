package week6

object maps {
  val romanNumerals = Map("I" -> 1 , "V" -> 5, "X" -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -
                                                  //| > 5, X -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)
  capitalOfCountry("US")                          //> res0: String = Washington
     capitalOfCountry get "Andorra"               //> res1: Option[String] = None
     capitalOfCountry get "US"                    //> res2: Option[String] = Some(Washington)
    
    
     
   def showCapital(country: String) = capitalOfCountry.get(country) match {
   	case Some(capital) => capital
   	case None => "missing data"
   }                                              //> showCapital: (country: String)String
   
   showCapital("US")                              //> res3: String = Washington
   
   capitalOfCountry map (x => x)                  //> res4: scala.collection.immutable.Map[String,String] = Map(US -> Washington, 
                                                  //| Switzerland -> Bern)
    for {
    	(x,y) <- capitalOfCountry
    } yield x                                     //> res5: scala.collection.immutable.Iterable[String] = List(US, Switzerland)
   
   val fruit = List("apple","pear","orange","pineapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pineapple)
   fruit sortWith (_.length < _.length)           //> res6: List[String] = List(pear, apple, orange, pineapple)
   fruit.sorted                                   //> res7: List[String] = List(apple, orange, pear, pineapple)
   
   fruit groupBy (_.head)                         //> res8: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pineapple), a -> List(apple), o -> List(orange))
   
   val a =List((1,2),(2,3))                       //> a  : List[(Int, Int)] = List((1,2), (2,3))
   val b = (2,2)                                  //> b  : (Int, Int) = (2,2)
   

  		( for {
  			(exp, coeff) <- a
  			if (b._1) == exp
  		} yield (exp,b._2 + coeff) ).head //> res9: (Int, Int) = (2,5)
  
   
}