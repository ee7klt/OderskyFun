package funsets

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  // test("string take") {
  //   val message = "hello, world"
  //   assert(message.take(5) == "hello")
  // }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  // test("adding ints") {
  //   assert(1 + 2 === 3)
  // }


  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(-2)
    val s3 = singletonSet(0)
    val s4 = (x:Int) => x>=0 && x<=5
    val s5 = (x:Int) => x>=4 && x<=10
     val p1 = (x:Int) => x>=4 && x<=10
     val p2 = (x:Int) => x>= -1 && x<=6
     val f1 = (x:Int) => x*x                      // mapping function
     val s6 = (x:Int) => x==1 || x==2 || x == 3   // map input
     val s7 = (x:Int) => x==1 || x==4 || x==9  // map output
     
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }
  
  
  test("singletonSet(-2) contains -2") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s2, -2), "Singleton")
    }
  }
  
  test("singletonSet(0) contains 0") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s3, 0), "Singleton")
    }
  }
  
  

  test("union contains all elements of each set") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1) === true, "Union 1")
      assert(contains(s, -2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
   test("intersection contains common elements of each set") {
    new TestSets {
      val s = intersect(s4, s5)
      assert(contains(s, 4), "intersection 1")
      assert(contains(s, 5), "intersection 2")
      assert(!contains(s, 6), "intersection 3")
    }
  }
   
   test("diff contains elements in one set but not in the other") {
    new TestSets {
      val s = diff(s4, s5)
      assert(!contains(s, 4), "diff 1")
      assert(!contains(s, 5), "diff 2")
      assert(contains(s, 0), "diff 3")
    }
  }
   
   
   test("filter contains elements of the first set which meet the criteria of the filtering function (second arg)") {
    new TestSets {
      val s = filter(s4, p1)
      assert(contains(s, 4), "filter 1")
      assert(contains(s, 5), "filter 2")
      assert(!contains(s, 0), "filter 3")
    }
  }
   
    test("forall tests if a predicate is true for all elements of a given set 1") {
    new TestSets {
      val s = forall(s4, p2)
      assert(s, "forall 1")
    }
  }
    
     test("forall tests if a predicate is true for all elements of a given set 2") {
    new TestSets {
      val s = forall(s4, p1)
      assert(!s, "forall 2")
    }
  }
     
      test("exists tests if there is a bounded integer within s that also satisfies p") {
    new TestSets {
      val s = exists(s4, p1)
      assert(s, "exists 1")
    }
  }
      
       test("map returns a set transformed by applying `f` to each element of `s`.") {
    new TestSets {
      val s = map(s6, f1)
      assert(s(4), "map 1")
       assert(!s(2), "map 2")
    }
  }



}
