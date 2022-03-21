package leetcode.offer.offer29_clockwisePrintRect;

import java.util.ArrayList;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/submissions/
 */
class Solution {
// [1 2 3 4]
// [5 6 7 8]
// [9 10 11 12]
//
public int[] spiralOrder(int[][] matrix) {
        int rowLen = matrix.length;
        if (rowLen == 0) return new int[0];

        int colLen = matrix[0].length;

        int rowStart = 0, rowEnd = rowLen - 1;
        int colStart = 0, colEnd = colLen - 1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(;;) {
        int i, j = rowStart;
        // print top row
        for(i = colStart; i <= colEnd; i++) {
        ans.add(matrix[j][i]);
        }

        j++; i = colEnd;
        // print right column
        if (j > rowEnd) break;
        for(; j <= rowEnd; j++) {
        ans.add(matrix[j][i]);
        }

        i--; j = rowEnd;
        // print bottom row
        if (colStart > i) break;
        for(; i >= colStart; i--) {
        ans.add(matrix[j][i]);
        }

        j--; i = colStart;
        // print left column
        if (rowStart + 1 > j) break;
        for(; j >= rowStart + 1; j--) {
        ans.add(matrix[j][i]);
        }

        rowStart++; rowEnd--;
        colStart++; colEnd--;
        // System.out.println(rowStart + " " + rowEnd);
        // System.out.println(colStart + " " + colEnd);
        if (rowStart > rowEnd || colStart > colEnd) break;
        }

        return ans.stream().mapToInt(i -> i).toArray();
        }
        }