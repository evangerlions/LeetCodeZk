import leetcode.offer17_print1toN.Solution_BigNumber
import leetcode.offer19_regularMatch.Solution
import kotlin.math.abs


fun main(args: Array<String>) {
    println(
        'B'.toInt()

    )
    println(Solution().isMatch("a", "a*a"))
}

private fun getDigitSum(a : Int): Int {
    var sum = 0
    var num = a
    while(num > 0) {
        sum += sum + num % 10
        num /= 10
    }
    return sum
}