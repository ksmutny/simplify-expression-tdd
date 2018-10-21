package exp

sealed trait Expression

case class Number(n: Int) extends Expression
case class Variable(name: String) extends Expression

case class Sum(terms: List[Expression]) extends Expression {
  require(terms.size >= 2)
}

case class Product(terms: List[Expression]) extends Expression {
  require(terms.size >= 2)
}
