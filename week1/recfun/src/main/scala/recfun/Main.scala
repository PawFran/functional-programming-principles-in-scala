package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if(c == 0 || c == r) 1
      else pascal(c - 1, r - 1) + pascal(c, r - 1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
        def helper(diff: Int, chars: List[Char]): Boolean = {
          if(chars.isEmpty) diff == 0
          else if(diff < 0) false
          else if(chars.head == '(') helper(diff + 1 , chars.tail)
          else if(chars.head == ')') helper(diff - 1 , chars.tail)
          else helper(diff, chars.tail)
        }
      helper(0, chars)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if(coins.isEmpty) 0
      else if(money == coins.min) 1
      else if(coins.min > money) 0
      else countChange(money - coins.min, coins) + countChange(money, coins diff List(coins.min))
    }

  }
