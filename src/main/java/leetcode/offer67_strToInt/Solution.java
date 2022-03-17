package leetcode.offer67_strToInt;

/**
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 * 剑指 Offer 67. 把字符串转换成整数
 */
public class Solution {

    public int strToInt(String str) {
        String ts = str.trim();
        if (ts.isEmpty()) return 0;

        boolean positive = false;
        int startDigitI = 0;
        if (ts.charAt(0) == '+') {
            positive = true;
            startDigitI = 1;
        } else if (ts.charAt(0) == '-') {
            positive = false;
            startDigitI = 1;
        } else if (isDigit(ts.charAt(0))) {
            positive = true;
        } else {
            return 0;
        }

        for (int i = startDigitI; i < ts.length(); i++) {
            if (ts.charAt(i) == '0') { startDigitI = i; }
            else { break; }
        }
        int lastDigitI = 0;
        int[] digits = new int[31];
        for (int i = startDigitI; i < ts.length(); i++) {
            if (isDigit(ts.charAt(i)) ) {
                lastDigitI = i;
            } else {
                break;
            }
        }

        long ret = 0;
        long factor = 1;
        int limitStartDigitI = Math.max(startDigitI, lastDigitI - 31);

        for (int i = lastDigitI; i >= limitStartDigitI; i--) {
            int n = ts.charAt(i) - '0';
            ret += n * factor;
            if (ret > Integer.MAX_VALUE || factor > Integer.MAX_VALUE) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            factor *= 10;
        }

        // System.out.println("" + startDigitI + " " + limitStartDigitI + " " + ret);

        int intRet = (int) ret;
        return positive ? intRet : (-intRet);
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
