package recfun
import common._
object Main {
  /**
   * Exercise 1
   */
  def s_bal(chars: String): Boolean = {
    def bal_aux(l: List[Char], c: Int): Boolean ={
      if (c < 0) false
      else if (l.isEmpty) {
        if (c==0) true else false
      }
      else if (l.head == '(') bal_aux(l.tail, c+1)
      else if (l.head == ')') bal_aux(l.tail ,c-1)
      else bal_aux(l.tail,c)
    }
    bal_aux(chars.toList, 0)
  }
  var res1 = s_bal("This is not) ((pretty good) example.")
  var res2 = s_bal("( () () (Hello))")
  /**
   * Exercise 2
   */
  def count_Chg(money: Int, coins: List[Int]): Int = {
    if (money == 0) {
      1
    } else if (money < 0 || coins.isEmpty) {
      0
    } else {
      count_Chg((money - coins.head, coins) + count_Chg((money, coins.tail)
    }
  }
  var res3 = count_Chg((10, List(1, 5))
  var res4 = count_Chg((12, List(2, 3,5,6))
  println(s"Output of balance test 1 = $res1 and test 2 = $res2")
  println(s"Output of countChange test 1 = $res3 and test 2 = $res4")
}
