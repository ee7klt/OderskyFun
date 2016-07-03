package week5

object scratch {
  
def last[T](xs: List[T]): T = xs match {
 case List() => throw new Error("Last of empty list")
 case List(x) => x
 case y::ys => last(ys)
}                                                 //> last: [T](xs: List[T])T


last(List(1,2,3))                                 //> res0: Int = 3


def init[T](xs: List[T]): List[T] = xs match {
case List() => throw new Error("init of empty list")
case List(x) => Nil
case y::ys => y::init(ys)
}                                                 //> init: [T](xs: List[T])List[T]

init(List(1,2,3))                                 //> res1: List[Int] = List(1, 2)


def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
	case Nil => ys
	case z::zs => z::concat(zs,ys)
}                                                 //> concat: [T](xs: List[T], ys: List[T])List[T]

concat(List(1,2,3),List(4,5,6))                   //> res2: List[Int] = List(1, 2, 3, 4, 5, 6)


def reverse[T](xs: List[T]): List[T] = xs match {
 case List() => List()
 case y::ys => reverse(ys):+y
}                                                 //> reverse: [T](xs: List[T])List[T]

reverse(List(1,2,3))                              //> res3: List[Int] = List(3, 2, 1)


def removeAt[T](xs: List[T], n: Int): List[T] = xs match {
	case List() => List()
	case y::ys => {
		if (n > xs.length) xs
		else if (n == 0) ys
		else y::removeAt(ys,n-1)
	}
	
}                                                 //> removeAt: [T](xs: List[T], n: Int)List[T]

 removeAt(List('a','b','c'),1)                    //> res4: List[Char] = List(a, c)
List(1,2,3) indexOf 2                             //> res5: Int = 1




// xs and ys are both already sorted
// so to put them in order, we just need to compare the first element of each list
// possibly. do we need to compare the case where they heads are the same?
// that should've been automatically taken care of since we're building from the bottomup no?

// non-symmetric merge
def mergeNS(xs: List[Int], ys: List[Int]): List[Int] =  xs match {
	case List() => ys
	case p::ps => ys match {
	  case List() => xs
	  case q::qs => {
	     if (p < q) p::mergeNS(ps,ys)
	     else if (p > q) q::mergeNS(xs,qs)
	     else p::q::mergeNS(ps,qs)
	   
	  }
	  
	 // case q::qs => {
	 // 	if (p == q) p::q::merge(ps,qs)
	 // 	else if (p < q) p::merge(ps,ys)
	 // 	else if (p > q) q::merge(xs,qs)
	 // }
	}
	
}                                                 //> mergeNS: (xs: List[Int], ys: List[Int])List[Int]




def msort(xs: List[Int]): List[Int] = {

	val n = xs.length/2
	if (n == 0) xs
	else {
		val (fst, snd) = xs splitAt n
		merge(msort(fst), msort(snd))
	}
	

}                                                 //> msort: (xs: List[Int])List[Int]
//symmetric merge

def merge(xs: List[Int], ys: List[Int]): List[Int] =
	(xs,ys) match {
		case (Nil, ys) => ys
		case (xs ,Nil) => xs
		case (x::xs1, y::ys1) => {
			if (x < y) x::merge(xs1,ys)
			else y::merge(xs,ys1)
		}
		
	}                                         //> merge: (xs: List[Int], ys: List[Int])List[Int]

merge(List(),List(1,2,3))                         //> res6: List[Int] = List(1, 2, 3)
merge(List(1,2,3),List())                         //> res7: List[Int] = List(1, 2, 3)
merge(List(2,4,90), List(1,3,5,6,7))              //> res8: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 90)
msort(List(1,3,5,2,4,6))                          //> res9: List[Int] = List(1, 2, 3, 4, 5, 6)
msort(List(4,1,-3,2))                             //> res10: List[Int] = List(-3, 1, 2, 4)
msort(List(2,1,4,1,1,2))                          //> res11: List[Int] = List(1, 1, 1, 2, 2, 4)


// parameterized mergesort
def msortp[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
	val n = xs.length/2
	if (n == 0) xs
	else {
		val (fst, snd) = xs splitAt n
		def mergep(xs: List[T], ys: List[T]): List[T] =
			(xs,ys) match {
			case (Nil, ys) => ys
			case (xs ,Nil) => xs
			case (x::xs1, y::ys1) => {
			if (ord.lt(x,y)) x::mergep(xs1,ys)
			else y::mergep(xs,ys1)
		}
		
	}
		
		mergep(msortp(fst), msortp(snd))
	}
}                                                 //> msortp: [T](xs: List[T])(implicit ord: Ordering[T])List[T]


msortp(List(3,5,2,6))                             //> res12: List[Int] = List(2, 3, 5, 6)
val fruits = List("apple","pineapple","orange","banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)

msortp(fruits)                                    //> res13: List[String] = List(apple, banana, orange, pineapple)
                                                  

 // these are fine, but need to take care of when either or both hits the end of the list
 // else if (xs.head == ys.head) xs.head::ys.head::merge(xs.tail,ys.tail)
 // else if (xs.head < ys.head) xs.head::merge(xs.tail,ys)
 // else if (xs.head > ys.head) ys.head::merge(xs, ys.tail)


val (a,b) = List(1,2,3,4) splitAt 1               //> a  : List[Int] = List(1)
                                                  //| b  : List[Int] = List(2, 3, 4)

}