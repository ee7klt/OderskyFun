package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
	trait TestTrees {
		val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
		val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
	}


  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }


  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }


  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

   test("times function test") {
      assert(times(List('a', 'b','a')) === List(('a',2),('b',1)))
  }


  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

test("singleton returns true for a List of one element, false otherwise") {
  new TestTrees {
  assert(singleton(List(t1,t2)) === false)
  assert(singleton(List(t1)) === true)
    assert(singleton(List()) === false)
  }
}

test("sortCodeTreeList 1") {
  val leaflist = List(Leaf('e', 3), Leaf('t', 2), Leaf('x', 4))
  assert(sortCodeTreeList(leaflist) === List(Leaf('t', 2), Leaf('e', 3), Leaf('x', 4)))
}

test("sortCodeTreeList 2") {
  val leaflist = List(Leaf('e', 6), Leaf('t', 2), Leaf('x', 4))
  assert(sortCodeTreeList(leaflist) === List(Leaf('t', 2), Leaf('x', 4), Leaf('e', 6)))
}

test("sortCodeTreeList 3") {
  val leaflist = List(Leaf('x', 6))
  assert(sortCodeTreeList(leaflist) === List(Leaf('x', 6)))
}

test("sortCodeTreeList for list of forks") {
  val forklist = List(
            Fork(Leaf('a',2),Leaf('b',3),List('a', 'b'),5),
             Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3)
            )
  val sortedforklist =  List(
        Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3),
            Fork(Leaf('a',2),Leaf('b',3),List('a', 'b'),5)
            )
  assert(sortCodeTreeList(forklist) === sortedforklist)
}
  
  test("combine of some leaf list 1") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }
  
    test("combine of some leaf list 2") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 5), Leaf('x', 4))
    assert(combine(leaflist) === List( Leaf('x',4), Fork(Leaf('e',1),Leaf('t',5),List('e', 't'),6)))
  }


    
    test("until applied to a list of leafs 1") {
      val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(
      until(singleton,combine)(leaflist) === 
      List(
          Fork(
            Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), 
            Leaf('x',4),
            List('e','t','x'),
            7
            )
          )
      )   
    
    }
    
      test("until applied to a list of leafs 2") {
      val leaflist = List(Leaf('e', 2), Leaf('t', 3), Leaf('x', 4))
      val untiledleaflist =    
        List(
          Fork(
            Leaf('x',4),
            Fork(Leaf('e',2),Leaf('t',3),List('e', 't'),5), 
            List('x','e','t'),
            9
            )
          )
    assert(
      until(singleton,combine)(leaflist) === untiledleaflist
  
      )   
    
    }
    
     test("until applied to a list of forks") {
      val forklist = List(
          Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3),
            Fork(Leaf('a',2),Leaf('b',3),List('a', 'b'),5)
             
            )
    assert(
      until(singleton,combine)(forklist) === 
      List(
          Fork(
            Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), 
            Fork(Leaf('a',2),Leaf('b',3),List('a', 'b'),5),
            List('e','t','a','b'),
            8
            )
          )
      )   
    
    }
    
    

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

}
