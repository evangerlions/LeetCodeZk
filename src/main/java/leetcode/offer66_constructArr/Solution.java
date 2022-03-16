package leetcode.offer66_constructArr;

/**
 * 剑指 Offer 66. 构建乘积数组
 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 */
public class Solution {
    public int[] constructArr(int[] a) {
        if (a.length < 1) return new int[0];

        int[] upTri = new int[a.length];
        int[] downTri = new int[a.length];
        int[] ret = new int[a.length];

        int index = a.length - 1;
        for (int i = 0; i < index; i++) {
            upTri[i] = 1;
            downTri[i] = 1;
        }

        for (int i = 1; i <= index; i++) {
            upTri[i] = upTri[i - 1] * a[i - 1];
            downTri[i] = downTri[i - 1] * a[index - i + 1];
            // System.out.println("upTri " + i + " = " + upTri[i] + " downTri " + (i) + " = " + downTri[i]);
        }

        for (int i = 0; i <= index; i++) {
            ret[i] = upTri[i] * downTri[index - i];
        }

        return ret;
    }
}
