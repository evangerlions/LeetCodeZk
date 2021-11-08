package leetcode.offer07_rebuildBinaryTree

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty() || inorder.isEmpty()) {
            return null
        }
        return innerBuild(preorder.toList(), inorder.toList())
    }

    private fun innerBuild(preorder: List<Int>, inorder: List<Int>): TreeNode {
        // println("preorder: $preorder inorder: $inorder")
        // generate root node
        val root = TreeNode(preorder[0])

        val index = inorder.indexOf(root.`val`)

        // left tree node count
        val leftCount = index
        // right tree node count
        val rightCount = inorder.lastIndex - index

        if (leftCount > 0) {
            root.left = innerBuild(preorder.slice(1..leftCount), inorder.take(leftCount))
        }
        if (rightCount > 0) {
            root.right = innerBuild(preorder.slice((leftCount + 1)..preorder.lastIndex), inorder.takeLast(rightCount))
        }
        return root
    }
}