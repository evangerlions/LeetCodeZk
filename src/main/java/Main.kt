import leetcode.offer.offer19_regularMatch.Solution
import java.util.*

var b : Objects? = null

fun main(args: Array<String>) {
    println(
        'B'.toInt()

    )
    b?.let {
        println(it.hashCode())
    }
    b.hashCode()
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