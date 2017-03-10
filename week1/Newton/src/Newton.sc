def abs (x: Double) = if(x < 0) -x else x

def sqrt(x: Double) = {

  def sqrtIter(quess: Double, x: Double): Double =
    if (isGoodEnough(quess)) quess
    else sqrtIter(improve(quess), x)

  def isGoodEnough(quess: Double) =
    abs(quess * quess - x) < (x / 1000)

  def improve(quess: Double) =
    (quess + x / quess) / 2

  sqrtIter(1.0, x)
}

sqrt(1)
sqrt(2)
sqrt(4)
sqrt(1e-6)
sqrt(1e200)

sqrt(0.001)
sqrt(0.1e-20)
sqrt(1.0e20)
sqrt(1.0e50)