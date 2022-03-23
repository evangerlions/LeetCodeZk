package leetcode.offer2.offer2_2_addBinary;

/**
 * 剑指 Offer II 002. 二进制加法
 * https://leetcode-cn.com/problems/JFETK5/
 */
public class Solution {
    public String addBinary(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) return "";

        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder sb = new StringBuilder();

        int carry = 0;
        while(i >= 0 || j >= 0) {
            int left = isValidIndex(a, i) ? a.charAt(i)  - '0' : 0;
            int right = isValidIndex(b, j) ? b.charAt(j)  - '0' : 0;
            int sum = left + right + carry;
            if (sum >= 2) {
                carry = 1;
                sum -= 2;
            } else {
                carry = 0;
            }
            sb.append(sum);
            i--;
            j--;
        }
        if (carry > 0) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    private boolean isValidIndex(String str, int i) {
        return i >= 0 && i <= str.length() - 1;
    }
}
