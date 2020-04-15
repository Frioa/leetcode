package com.yue.medium.`542 0-1矩阵`

import java.util.*


class Solution {

    lateinit var resArray: Array<IntArray>
    lateinit var q: Queue<point>
    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        q = LinkedList<point>()
        resArray = Array(matrix.size) {
            IntArray(matrix[0].size) { 999999 }
        }

        if (matrix.isEmpty()) return resArray

        for (col in matrix.indices) {
            for (row in matrix[col].indices) {
                if (matrix[col][row] == 0) q.offer(point(col, row, 0))
            }
        }



        while (q.isNotEmpty()) {
            val p = q.poll()
            if (resArray[p.col][p.row] > p.value) resArray[p.col][p.row] = p.value

            if (p.col - 1 >= 0 && resArray[p.col - 1][p.row] > p.value + 1) q.offer(point(p.col - 1, p.row, p.value + 1))
            if (p.col + 1 < matrix.size && resArray[p.col + 1][p.row] > p.value + 1) q.offer(point(p.col + 1, p.row, p.value + 1))

            if (p.row - 1 >= 0 && resArray[p.col][p.row- 1] > p.value + 1) q.offer(point(p.col, p.row - 1, p.value + 1))
            if (p.row + 1 < matrix[0].size && resArray[p.col][p.row + 1] > p.value + 1) q.offer(point(p.col, p.row + 1, p.value + 1))
        }


        return resArray
    }


    class point constructor(val col: Int, val row: Int, val value: Int)
}
