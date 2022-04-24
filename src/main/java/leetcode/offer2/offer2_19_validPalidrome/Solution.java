package leetcode.offer2.offer2_19_validPalidrome;

/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 * https://leetcode-cn.com/problems/RQku0D/
 */
public class Solution {
    public boolean validPalindrome(String s) {
        return isPalindrome(s, true);
    }

    public boolean isPalindrome(String s, boolean allowDelete) {
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
                if (allowDelete) {
                    return isPalindrome(s.substring(i, j), false) || isPalindrome(s.substring(i + 1, j + 1), false);
                }
                return false;
            } else {
                j--;
                i++;
            }
        }
        return true;
    }

    private Character getLowerCase(char c) {
        if (!Character.isLetterOrDigit(c)) {
            return null;
        }

        return Character.toLowerCase(c);
    }
}
