package leetcode.offer19_regularMatch

/**
 * 剑指 Offer 19. 正则表达式匹配
 * https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 */
class Solution {
    fun isMatch(s: String, p: String): Boolean {
        return matchCore(s, p, 0, 0)
    }

    private fun matchCore(s: String, p: String, si: Int, pi:Int, compareChar: Char? = null): Boolean {
        if(si >= s.length && pi >= p.length) {
            return true
        }

        if (compareChar == null && pi + 1 < p.length && p[pi + 1] == '*') {
            // 为什么或前面的这一行是不能去的？
            // 因为后面的判断对 a* 的匹配是会命中至少一个 a 的，但是有可能原字符串一个 a 都不能命中，例如 a a*a
            return matchCore(s, p, si, pi + 2) || matchCore(s, p, si, pi + 2, p[pi])
        }

        if (compareChar != null && si < s.length) {
            if (s[si] != compareChar && compareChar != '.') {
                // 已经匹配不到 * 重复的了，继续匹配 * 后面的字符
                return matchCore(s, p, si, pi, null)
            }
            // 下一个字符也是 * 重复的 || 下一个字符不属于 *
            return matchCore(s, p, si + 1, pi, compareChar) || matchCore(s, p, si + 1, pi, null)
        }

        // 除了 pattern 最后是 * 的情况，有一个走到头了，另外一个字符串还有东西，这时候肯定匹配不上
        if(si >= s.length || pi >= p.length) {
            return false
        }

        if (p[pi] == '.' || p[pi] == s[si]) {
            return matchCore(s, p, si + 1, pi + 1)
        } else {
            return false
        }
    }
}