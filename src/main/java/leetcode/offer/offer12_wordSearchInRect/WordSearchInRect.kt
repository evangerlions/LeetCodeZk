package leetcode.offer.offer12_wordSearchInRect

/**
 * 剑指 Offer 12. 矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
class Solution {

    private data class IndexXY(
        val x: Int,
        val y: Int
    )

    fun exist(board: Array<CharArray>, word: String): Boolean {
        if (word.isEmpty() || board.isEmpty() || board[0].isEmpty()) return false

        for ((i, row) in board.withIndex()) {
            for ((j, item) in row.withIndex()) {
                if (item == word[0]) {
                    val existIndices = mutableListOf(IndexXY(j, i))
                    if (findPathCore(board, existIndices, word)) return true
                }
            }
        }
        return false
    }

    private fun findPathCore(board: Array<CharArray>, existIndices: MutableList<IndexXY>, targetWord: String): Boolean {

        if (existIndices.size == targetWord.length) {
            return true
        }
        val currentSize = existIndices.size
        val value = existIndices.last()

        val left = IndexXY(value.x - 1, value.y)
        val right = IndexXY(value.x + 1 , value.y)
        val up = IndexXY(value.x, value.y - 1)
        val down = IndexXY(value.x, value.y + 1)

        val nextNodes = listOf(left, right, up, down)

        val targetChar = targetWord[currentSize]

        for (item in nextNodes) {
            if (existIndices.safeAdd(item, board, targetChar)) {
                val result = findPathCore(board, existIndices, targetWord)
                // 有一个成功就算成功
                if (result) return true
            }
            while (existIndices.size > currentSize) {
                existIndices.removeAt(existIndices.lastIndex)
            }
        }

        return false
    }

    private fun MutableList<IndexXY>.safeAdd(indexXY: IndexXY, board: Array<CharArray>, targetChar: Char) :Boolean {
        val maxX = board[0].lastIndex
        val maxY = board.lastIndex


        if(indexXY.x < 0 || indexXY.x > maxX || indexXY.y < 0 || indexXY.y > maxY) {
            return false
        }

        for (item in this) {
            if (item == indexXY) return false
        }

        val boardChar = board[indexXY.y][indexXY.x]
        if (boardChar != targetChar) return false

        add(indexXY)
        return true
    }
}