package leetcode.offer.offer28_symmetricTree

/**
 * 剑指 Offer 28. 对称的二叉树
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        root ?: return true

        val preOrder = mutableListOf<Int?>()
        val reversePreOrder = mutableListOf<Int?>()

        preTraverse(root, preOrder)
        reversePreTraverse(root, reversePreOrder)
        println("pre $preOrder")
        println("rev $reversePreOrder")

        if (preOrder.size != reversePreOrder.size) return false

        for (i in preOrder.indices) {
            if (preOrder[i] != reversePreOrder[i]) return false
        }
        return true
    }

    private fun preTraverse(node: TreeNode?, orderList: MutableList<Int?>) {
        if (node == null) {
            orderList.add(null)
            return
        }

        orderList.add(node.`val`)
        preTraverse(node.left, orderList)
        preTraverse(node.right, orderList)
    }

    private fun reversePreTraverse(node: TreeNode?, orderList: MutableList<Int?>) {
        if (node == null) {
            orderList.add(null)
            return
        }

        orderList.add(node.`val`)
        reversePreTraverse(node.right, orderList)
        reversePreTraverse(node.left, orderList)
    }
}