package com.yue.easy.`961重复N次元素`

class Solution {
    fun repeatedNTimes(A: IntArray): Int {
        for (i in 0..A.lastIndex - 2) {
            if (A[i] == A[i+1] || A[i] == A[i + 2]) return A[i]
        }

        return A[A.lastIndex]
    }
}