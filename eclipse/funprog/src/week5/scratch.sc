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
		else if (n == (xs indexOf y)) {
		println(n, y)
		 removeAt(ys,n)
		}
		else {
		println (n, y, xs indexOf y, xs)
		y::removeAt(ys,n)
		}
	}
	
}                                                 //> removeAt: [T](xs: List[T], n: Int)List[T]

 removeAt(List('a','b','c'),1)                    //> (1,a,0,List(a, b, c))
                                                  //| (1,b,0,List(b, c))
                                                  //| (1,c,0,List(c))
                                                  //| res4: List[Char] = List(a, b, c)
List(1,2,3) indexOf 2                             //> res5: Int = 1

}