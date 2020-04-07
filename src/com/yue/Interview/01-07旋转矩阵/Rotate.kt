package com.yue.Interview.`01-07旋转矩阵`

/*

给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。

不占用额外内存空间能否做到？
https://leetcode-cn.com/problems/rotate-matrix-lcci/

示例 1:

给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
示例 2:

给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */

class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        for (c in 0..(matrix.lastIndex / 2)) {
            for (r in c until matrix.lastIndex - c) _swap(matrix, c, r)
        }
    }

    private fun _swap(matrix: Array<IntArray>, c: Int, r: Int) {
        swap(matrix, c, r, matrix.lastIndex - r, c)
        swap(matrix, matrix.lastIndex - r, c, matrix.lastIndex- c, matrix.lastIndex - r)
        swap(matrix, matrix.lastIndex- c, matrix.lastIndex - r, r, matrix.lastIndex - c)
    }

    private fun swap(arr: Array<IntArray>, i: Int, j: Int, ii: Int, jj: Int) {
        if  (i == ii && j == jj) return

        val tmp = arr[i][j]
        arr[i][j] = arr[ii][jj]
        arr[ii][jj] = tmp
    }
}


fun main() {

}