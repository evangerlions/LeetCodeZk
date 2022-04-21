package leetcode.offer2.offer2_18_isPalindrome;

/**
 * https://leetcode-cn.com/problems/XltzEq/
 * 剑指 Offer II 018. 有效的回文
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;

        int i = 0;
        int j = s.length() - 1;

        while(j >= 0 && i < s.length()) {
            Character jc = getLowerCase(s.charAt(j));
            Character ic = getLowerCase(s.charAt(i));
            if (jc == null) {
                j--;
            } else if (ic == null) {
                i++;
            } else if (!jc.equals(ic)) {
                return false;
            } else {
                j--;
                i++;
            }
        }
        return true;
    }

    private Character getLowerCase(char c) {
        if (c >= '0' && c <= '9') return c;

        if (c >= 'a' && c <= 'z') return c;

        if (c >= 'A' && c <= 'Z') return (char) (c + ('a' - 'A'));

        return null;
    }
}
