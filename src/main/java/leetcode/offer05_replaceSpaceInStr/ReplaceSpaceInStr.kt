package leetcode.offer05_replaceSpaceInStr

/**
 * 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
class Solution {
    fun replaceSpace(s: String): String {
        var newStr = ""
        for (c in s) {
            if (c == ' ') {
                newStr += "%20"
            } else {
                newStr += c
            }
        }
        return newStr
    }
}

class Solution_UseOneArray {
    fun replaceSpace(s: String): String {
        if (s.isEmpty()) {
            return ""
        }

        var spaceCount = 0
        for (c in s) {
            if (c == ' ') {
                spaceCount++
            }
        }
        val newStrLength = s.length + spaceCount * 2
        println(newStrLength)
        val newStr = CharArray(newStrLength)
        var i = s.lastIndex
        var j = newStr.lastIndex

        while (i >= 0 && j >= 0) {
            if (s[i] == ' ') {
                newStr[j] = '0'
                j--
                newStr[j] = '2'
                j--
                newStr[j] = '%'
            } else {
                newStr[j] = s[i]
            }
            i--
            j--
        }
        println(newStr.joinToString(""))
        return newStr.joinToString("")
    }
}
