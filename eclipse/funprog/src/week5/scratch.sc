package week5

object scratch {
  
def last[T](xs: List[T]): T = xs match {
 case List() => throw new Error("Last of empty list")
 case List(x) => x
 case y::ys => last(ys)
}


last(List(1,2,3))


def init[T](xs: List[T]): List[T] = xs match {
case List() => throw new Error("init of empty list")
case List(x) => Nil
case y::ys => y::init(ys)
}

init(List(1,2,3))


def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
	case Nil => ys
	case z::zs => z::concat(zs,ys)
}

concat(List(1,2,3),List(4,5,6))


def reverse[T](xs: List[T]): List[T] = xs match {
 case List() => List()
 case y::ys => reverse(ys):+y
}

reverse(List(1,2,3))


def removeAt[T](xs: List[T], n: Int): List[T] = xs match {
	case List() => List()
	case y::ys => {
		if (n > xs.length) xs
		else if (n == 0) ys
		else y::removeAt(ys,n-1)
	}
	
}

 removeAt(List('a','b','c'),1)
List(1,2,3) indexOf 2




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
	
}




def msort(xs: List[Int]): List[Int] = {

	val n = xs.length/2
	if (n == 0) xs
	else {
		val (fst, snd) = xs splitAt n
		merge(msort(fst), msort(snd))
	}
	

}
//symmetric merge

def merge(xs: List[Int], ys: List[Int]): List[Int] =
	(xs,ys) match {
		case (Nil, ys) => ys
		case (xs ,Nil) => xs
		case (x::xs1, y::ys1) => {
			if (x < y) x::merge(xs1,ys)
			else y::merge(xs,ys1)
		}
		
	}

merge(List(),List(1,2,3))
merge(List(1,2,3),List())
merge(List(2,4,90), List(1,3,5,6,7))
msort(List(1,3,5,2,4,6))
msort(List(4,1,-3,2))
msort(List(2,1,4,1,1,2))


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
}


msortp(List(3,5,2,6))
val fruits = List("apple","pineapple","orange","banana")

msortp(fruits)
                                                  

 // these are fine, but need to take care of when either or both hits the end of the list
 // else if (xs.head == ys.head) xs.head::ys.head::merge(xs.tail,ys.tail)
 // else if (xs.head < ys.head) xs.head::merge(xs.tail,ys)
 // else if (xs.head > ys.head) ys.head::merge(xs, ys.tail)


val (a,b) = List(1,2,3,4) splitAt 1


def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
	case Nil => Nil
	case x::xs1 => (x*factor)::scaleList(xs1,factor)
}

scaleList(List(1,2,3), 0.2)

def squareList(xs: List[Double]): List[Double] = xs match {
	case List() => List()
	case x::xs1 => x*x::squareList(xs1)
}

squareList(List(1,2,3))


// filtering
// return all positive elements of the list
def posElems(xs: List[Int]): List[Int] = xs match {
case Nil => Nil
case x::xs1 => {
	if (x > 0) x::posElems(xs1)
	else posElems(xs1)
}
}

posElems(List(-3,4,5,-1))

val cats = List("Tiger", "Lion", "Puma", "Leopard",
                  "Jaguar", "Cheetah", "Bobcat")
val groupedByLength = cats.groupBy(_.length)
groupedByLength.toList()


}