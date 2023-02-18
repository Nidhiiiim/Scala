package recfun
import common._
object Main {
  /**
   * Exercise 1
   */
  def balance(chars: String): Boolean = {
    def balance_aux(l: List[Char], c: Int): Boolean ={
      if (c < 0) false
      else if (l.isEmpty) {
        if (c==0) true else false
      }
      else if (l.head == '(') balance_aux(l.tail, c+1)
      else if (l.head == ')') balance_aux(l.tail ,c-1)
      else balance_aux(l.tail,c)
    }
    balance_aux(chars.toList, 0)
  }
  var res1 = balance("This is not) ((pretty good) example.")
  var res2 = balance("( () () (Hello))")
  /**
   * Exercise 2
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) {
      1
    } else if (money < 0 || coins.isEmpty) {
      0
    } else {
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
  }
  var res3 = countChange(10, List(1, 5))
  var res4 = countChange(12, List(2, 3,5,6))
  println(s"Output of balance test 1 = $res1 and test 2 = $res2")
  println(s"Output of countChange test 1 = $res3 and test 2 = $res4")
}
