package leetcode.offer27_invertBinaryTree

/**
 * 剑指 Offer 27. 二叉树的镜像
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
class Solution {
    fun mirrorTree(root: TreeNode?): TreeNode? {
        root ?: return null

        val left = root.left
        root.left = root.right
        root.right = left

        mirrorTree(root.left)
        mirrorTree(root.right)

        return root
    }
}