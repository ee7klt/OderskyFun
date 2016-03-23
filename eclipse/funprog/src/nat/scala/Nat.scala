package nat.scala

/**
 * @author macgeekalex
 */
abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat 
  def successor: Nat 
  def + (that: Nat): Nat 
  def - (that: Nat): Nat 
}

class Succ(n: Nat) extends Nat {
  def isZero = false
  def predecessor: Nat = if (!n.isZero) n.predecessor else throw new Error("O.predecessor!")
  def successor: Nat = new Succ(n)
  def + (that: Nat): Nat = if (that.isZero) this else successor + that.predecessor
  def - (that: Nat): Nat = if (that.isZero) Zero else this - that.predecessor
  

}

object Zero extends Nat {
  def isZero = true
  def predecessor = throw new Error("0.predecessor")
  def successor = new Succ(Zero)
  def + (that: Nat):Nat = that
  def - (that: Nat):Nat = that
}

