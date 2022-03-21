package leetcode.offer.offer34_findPathsInTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        Stack<Integer> s = new Stack<>();
        pathSumCore(root, target, 0, ans, s);
        return ans;
    }

    private void pathSumCore(TreeNode root, int target, int curSum, List<List<Integer>> ans, Stack<Integer> s) {
        int thisSum = curSum + root.val;
        if (thisSum == target) {
            if (root.left == null && root.right == null) {
                s.add(root.val);
                ans.add(new ArrayList<Integer>(s));
                s.pop();
                return;
            }
        }

        curSum = thisSum;
        s.add(root.val);

        if (root.left != null) {
            pathSumCore(root.left, target, curSum, ans, s);
        }

        if (root.right != null) {
            pathSumCore(root.right, target, curSum, ans, s);
        }

        s.pop();
    }
}
