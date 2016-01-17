package week3

object overrides {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
}

abstract class Base {   // superclass
	def foo = 1
	def bar: Int
}

class Sub extends Base {   // subclass

// definition originally defined
	// in base class can be redefined using override
	 override def foo = 2   // replaces the concrete definition of foo in superclass
	    
	def bar = 3   // implements abstract definition of bar in superclass
}