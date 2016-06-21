import patmat.Huffman._


object patmatscratch {
 val x = 2::"p"::"s"::Nil                         //> x  : List[Any] = List(2, p, s)
  val y = ('w',1)::Nil                            //> y  : List[(Char, Int)] = List((w,1))
  (3,2).getClass.getSimpleName                    //> res0: String = Tuple2$mcII$sp
 (3,2)._1                                         //> res1: Int = 3
 val tuple = ('a', 1)                             //> tuple  : (Char, Int) = (a,1)
   // destructuring baby!
val (char, digit) = tuple                         //> char  : Char = a
                                                  //| digit  : Int = 1
val numbers = List(1, 2, 3, 4)                    //> numbers  : List[Int] = List(1, 2, 3, 4)


 // numbers.filter((i: Int) => i % 2 == 0)

def insert(x: Int, xs: List[Int]): List[Int] = xs match {
	case List() => List()
	 case y::ys => List()
}                                                 //> insert: (x: Int, xs: List[Int])List[Int]


Leaf('a',1)                                       //> res2: patmat.Huffman.Leaf = Leaf(a,1)



  val frenchCode: CodeTree = Fork(Fork(Fork(Leaf('s',121895),Fork(Leaf('d',56269),Fork(Fork(Fork(Leaf('x',5928),Leaf('j',8351),List('x','j'),14279),Leaf('f',16351),List('x','j','f'),30630),Fork(Fork(Fork(Fork(Leaf('z',2093),Fork(Leaf('k',745),Leaf('w',1747),List('k','w'),2492),List('z','k','w'),4585),Leaf('y',4725),List('z','k','w','y'),9310),Leaf('h',11298),List('z','k','w','y','h'),20608),Leaf('q',20889),List('z','k','w','y','h','q'),41497),List('x','j','f','z','k','w','y','h','q'),72127),List('d','x','j','f','z','k','w','y','h','q'),128396),List('s','d','x','j','f','z','k','w','y','h','q'),250291),Fork(Fork(Leaf('o',82762),Leaf('l',83668),List('o','l'),166430),Fork(Fork(Leaf('m',45521),Leaf('p',46335),List('m','p'),91856),Leaf('u',96785),List('m','p','u'),188641),List('o','l','m','p','u'),355071),List('s','d','x','j','f','z','k','w','y','h','q','o','l','m','p','u'),605362),Fork(Fork(Fork(Leaf('r',100500),Fork(Leaf('c',50003),Fork(Leaf('v',24975),Fork(Leaf('g',13288),Leaf('b',13822),List('g','b'),27110),List('v','g','b'),52085),List('c','v','g','b'),102088),List('r','c','v','g','b'),202588),Fork(Leaf('n',108812),Leaf('t',111103),List('n','t'),219915),List('r','c','v','g','b','n','t'),422503),Fork(Leaf('e',225947),Fork(Leaf('i',115465),Leaf('a',117110),List('i','a'),232575),List('e','i','a'),458522),List('r','c','v','g','b','n','t','e','i','a'),881025),List('s','d','x','j','f','z','k','w','y','h','q','o','l','m','p','u','r','c','v','g','b','n','t','e','i','a'),1486387)
                                                  //> frenchCode  : patmat.Huffman.CodeTree = Fork(Fork(Fork(Leaf(s,121895),Fork(
                                                  //| Leaf(d,56269),Fork(Fork(Fork(Leaf(x,5928),Leaf(j,8351),List(x, j),14279),Le
                                                  //| af(f,16351),List(x, j, f),30630),Fork(Fork(Fork(Fork(Leaf(z,2093),Fork(Leaf
                                                  //| (k,745),Leaf(w,1747),List(k, w),2492),List(z, k, w),4585),Leaf(y,4725),List
                                                  //| (z, k, w, y),9310),Leaf(h,11298),List(z, k, w, y, h),20608),Leaf(q,20889),L
                                                  //| ist(z, k, w, y, h, q),41497),List(x, j, f, z, k, w, y, h, q),72127),List(d,
                                                  //|  x, j, f, z, k, w, y, h, q),128396),List(s, d, x, j, f, z, k, w, y, h, q),2
                                                  //| 50291),Fork(Fork(Leaf(o,82762),Leaf(l,83668),List(o, l),166430),Fork(Fork(L
                                                  //| eaf(m,45521),Leaf(p,46335),List(m, p),91856),Leaf(u,96785),List(m, p, u),18
                                                  //| 8641),List(o, l, m, p, u),355071),List(s, d, x, j, f, z, k, w, y, h, q, o, 
                                                  //| l, m, p, u),605362),Fork(Fork(Fork(Leaf(r,100500),Fork(Leaf(c,50003),Fork(L
                                                  //| eaf(v,24975),Fork(Leaf(g,13288),Leaf(b,13822),List(g, b),27110),List(v, g, 
                                                  //| b),52085),List(c, v, g,
                                                  //| Output exceeds cutoff limit.

  /**
   * What does the secret message say? Can you decode it?
   * For the decoding use the `frenchCode' Huffman tree defined above.
   */
  val secret: List[Bit] = List(0,0,1,1,1,0,1,0,1,1,1,0,0,1,1,0,1,0,0,1,1,0,1,0,1,1,0,0,1,1,1,1,1,0,1,0,1,1,0,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,0,0,1,0,0,0,1,0,1)
                                                  //> secret  : List[patmat.Huffman.Bit] = List(0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 
                                                  //| 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 
                                                  //| 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 
                                                  //| 0, 1)

  /**
   * Write a function that returns the decoded secret
   */
    def decodedSecret: List[Char] = decode(frenchCode, secret)
                                                  //> decodedSecret: => List[Char]
      println(decodedSecret.toString)             //> List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
                                                  //| List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
}