package object exp {

  def print(expression: Expression): String = expression match {
    case Number(n) => n.toString
    case Variable(name) => name
  }
}
