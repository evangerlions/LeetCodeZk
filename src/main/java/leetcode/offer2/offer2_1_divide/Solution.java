package leetcode.offer2.offer2_1_divide;

public class Solution {
    public int divide(int a, int b) {
        if (b == 0) return -1;
        if (a == 0) return 0;

        boolean isNagative = false;
        long la = a;
        long lb = b;
        if (la < 0 && lb > 0) {
            la = -la;
            isNagative = true;
        } else if (a > 0 && b < 0) {
            lb = -lb;
            isNagative = true;
        } else if (a < 0 && b < 0) {
            la = -la;
            lb = -lb;
        }

        long ret = divideCore(la, lb);

        if (isNagative) {
            ret = -ret;
        }

        if (ret < Integer.MIN_VALUE) {
            ret = Integer.MIN_VALUE;
        }

        if (ret > Integer.MAX_VALUE) {
            ret = Integer.MAX_VALUE;
        }
        return (int) ret;
    }

    // a / b
    private long divideCore(long a, long b) {
        long ret = 0;
        while(a >= b) {
            long divide = b;
            long count = 1;
            while(divide + divide < a) {
                divide = divide + divide;
                count += count;
            }

            a = a - divide;
            ret += count;
        }
        return ret;
    }
}
