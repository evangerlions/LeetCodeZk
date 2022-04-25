package leetcode.offer2.offer2_20_countSubstrings;

/**
 * 剑指 Offer II 020. 回文子字符串的个数
 * https://leetcode-cn.com/problems/a7VOhD/
 */
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += isTargetStr(s, i, i);
            count += isTargetStr(s, i, i + 1);
        }
        return count;
    }

    private int isTargetStr(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }

        return count;
    }
}