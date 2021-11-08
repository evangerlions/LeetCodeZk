package leetcode.offer33_verifyPostOrder;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return verifyCore(postorder, 0, postorder.length - 1);
    }

    private boolean verifyCore(int[] postorder, int start, int end) {
        // System.out.println("start " + start + " end " + end);
        if (end - start <= 1) return true;
        // for (int i = start; i <= end; i++) {
        //     System.out.print(", " + postorder[i]);
        // }
        // System.out.println();

        int root = postorder[end];

        int rightTreeIndex = -1;
        for (int i = start; i <= end; i++) {
            if (postorder[i] > root) {
                rightTreeIndex = i;
                break;
            }
        }

        if (rightTreeIndex != -1) {
            for (int i = rightTreeIndex + 1; i <= end; i++) {
                if (postorder[i] < root) return false;
            }
        }

        return verifyCore(postorder, start, rightTreeIndex - 1) && verifyCore(postorder, Math.max(rightTreeIndex,start), end - 1);
    }
}