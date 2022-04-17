package leetcode.offer2.offer2_13_numMartix;

/**
 * https://leetcode-cn.com/problems/O4NDxx/
 * 剑指 Offer II 013. 二维子矩阵的和
 */
class NumMatrix {

    private int[][] sumArr;

    public NumMatrix(int[][] matrix) {
        sumArr = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                rowSum += matrix[i][j];
                if (i == 0) {
                    sumArr[i][j] = rowSum;
                } else {
                    sumArr[i][j] = rowSum + sumArr[i - 1][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int left =  (col1 - 1 >= 0) ? sumArr[row2][col1 - 1] : 0;
        int right = (row1 - 1 >= 0) ? sumArr[row1 - 1][col2] : 0;
        int add = (row1 - 1 >= 0 && col1 - 1 >= 0) ? sumArr[row1 - 1][col1 - 1] : 0;
        return sumArr[row2][col2] - left - right + add;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */