package object exp {

  def print(expression: Expression): String = expression match {
    case Number(n) => n.toString
    case Variable(name) => name
    case Sum(terms) => terms map print mkString " + "
    case Product(terms) => terms map {
      case sum: Sum => "(" + print(sum) + ")"
      case term => print(term)
    } mkString " * "
  }
}
