class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be different than 0")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val divisor = gcd(x, y)

  def numer = x
  def denom = y

  def add(that: Rational): Rational = {
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }

  def sub(that: Rational): Rational = {
    this.add(that.neg)
  }

  def mul(that: Rational): Rational = {
    new Rational(this.numer * that.numer, this.denom * that.denom)
  }

  def neg: Rational = {
    new Rational(-numer, denom)
  }

  def less(that: Rational) = {
    this.numer * that.denom < that.numer * this.denom
  }

  def maximum(that: Rational) = {
    if (this.less(that)) this else that
  }

  override def toString: String = {
    (this.numer / divisor) + "/" + (this.denom / divisor)
  }
}

val x = new Rational(1, 2)
val y = new Rational(3, 4)

x.add(y)
x.less(y)
x.maximum(y)

//val strange = new Rational(1, 0)
//strange.add(strange)

val integer = new Rational(3)