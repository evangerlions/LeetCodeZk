package leetcode.offer.offer26_isSubStructure

/**
 * 剑指 Offer 26. 树的子结构
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isSubStructure(A: TreeNode?, B: TreeNode?): Boolean {
        A ?: return false
        B ?: return false

        if (isSameTree(A, B)) { return true }

        return isSubStructure(A.left, B) || isSubStructure(A.right, B)
    }

    fun isSameTree(A: TreeNode?, B: TreeNode?): Boolean {
        if (A == null && B == null) return true
        if (A != null && B == null) return true
        if (A?.`val` != B?.`val`) {
            return false
        }

        return isSameTree(A?.left, B?.left) && isSameTree(A?.right, B?.right)
    }
}