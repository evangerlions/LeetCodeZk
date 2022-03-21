package leetcode.offer.offer58_reverseWordOrder;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 双指针
 */
public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int i = s.length() - 1;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }

            j = i;
            while(i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            for (int k = (i + 1); k <= j; k++) {
                sb.append(s.charAt(k));
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
