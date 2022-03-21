package leetcode.offer.offer20_judgeNumberStr

/**
 * 剑指 Offer 20. 表示数值的字符串
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 */
class Solution {
    fun isNumber(s: String): Boolean {
        val targetS = trimString(s)

        var eIndex = -1
        for ((i, c) in targetS.withIndex()) {
            if (c == 'e' || c == 'E') {
                // duplicate e, must illegal
                if (eIndex != -1) return false
                eIndex = i
            }
        }
        if (eIndex != -1) {
            //println("judgetE")
            return judgeIntegerOrFloat(safeSlice(targetS, 0, eIndex - 1)) &&
                    judgeInteger(safeSlice(targetS, eIndex + 1, targetS.lastIndex), false, true)
        }

        return judgeIntegerOrFloat(targetS)
    }

    private fun trimString(s: String): String {
        return s.trim()
    }

    private fun judgeIntegerOrFloat(targetS: String): Boolean {
        val res1 = judgeFloat(targetS)
        val res2 = judgeInteger(targetS)
        //println("judgeIntegerOrFloat Float: $res1 Integer: $res2")
        return res1 || res2
    }

    private fun judgeFloat(targetS: String): Boolean {
        if (targetS.isEmpty()) return false

        var dotIndex = -1
        for ((i, c) in targetS.withIndex()) {
            if (c == '.') {
                // duplicate . must illegal
                if (dotIndex != -1) { return false }
                dotIndex = i
            }
        }

        if (dotIndex != -1) {
            val part1 = safeSlice(targetS, 0, dotIndex - 1)
            val part2 = safeSlice(targetS, dotIndex + 1, targetS.lastIndex)
            //println("judgeFloat part1: $part1 part2: $part2 targets: $targetS dotIndex: $dotIndex")
            // 当小数点后没有数字时，前面必须包含数字
            if (part2.isEmpty()) {
                return judgeInteger(part1, false, true, false)
            }

            val res1 = judgeInteger(part1, true, true, true)
            val res2 = judgeInteger(part2, false, false) // 这里 part2 肯定不为空了，includeEmpty 传什么都行
            //println("judgeFloat res1: $res1 res2: $res2")
            return res1 && res2
        }

        return false
    }

    private fun judgeInteger(targetS: String, includeEmpty: Boolean = false, includeOp: Boolean = true, includeOnlyOp: Boolean = false): Boolean {
        if (targetS.isEmpty()) return includeEmpty

        if (!isDigit(targetS.first())) {
            if (!includeOp) return false

            if (targetS.first() == '+' || targetS.first() == '-') {
                // 只有一个正负号时算不算合法的，用于小数的小数点前半部分判断，此时是合法的
                if (targetS.length == 1) { return includeOnlyOp }
                return judgeNumbers(safeSlice(targetS, 1, targetS.lastIndex))
            }
            return false
        }

        return judgeNumbers(targetS)
    }

    /** return false when empty str */
    private fun judgeNumbers(s: String): Boolean {
        if (s.isEmpty()) return false

        for (c in s) {
            if(!isDigit(c)) return false
        }

        return true
    }

    private fun isDigit(c: Char): Boolean {
        return c in '0'..'9'
    }

    private fun safeSlice(s:String, start: Int, end: Int): String {
        if (start > end || end > s.lastIndex || start < 0) {
            return ""
        }

        return s.slice(start..end)
    }
}