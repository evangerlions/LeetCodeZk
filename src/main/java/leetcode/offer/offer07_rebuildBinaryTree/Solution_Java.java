package leetcode.offer.offer07_rebuildBinaryTree;

import java.util.HashMap;

class Solution_Java {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> inMap = new HashMap<>();

    private static class Range {
        int start;
        int end;

        Range(int s, int e) {
            this.start = s;
            this.end = e;
        }

        public int size() {
            return end - start + 1;
        }

        public boolean isEmpty() {
            return size() <= 0;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        this.preorder = preorder;
        this.inorder = inorder;

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return build(new Range(0, preorder.length - 1), new Range(0, inorder.length - 1));
    }

    private TreeNode build(Range pre, Range in) {
        TreeNode root = new TreeNode(preorder[pre.start]);

        int inIndex = inMap.get(root.val);

        Range inLeft = new Range(in.start, inIndex - 1);
        Range inRight = new Range(inIndex + 1, in.end);

        Range preLeft = new Range(pre.start + 1, pre.start + inLeft.size());
        Range preRight = new Range(preLeft.end + 1, pre.end);

        if (inLeft.isEmpty()) {
            root.left = null;
        } else {
            root.left = build(preLeft, inLeft);
        }

        if (inRight.isEmpty()) {
            root.right = null;
        } else {
            root.right = build(preRight, inRight);
        }

        return root;
    }
}