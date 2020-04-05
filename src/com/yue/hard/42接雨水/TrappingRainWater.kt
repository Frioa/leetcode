package com.yue.hard.`42接雨水`

/**
 *  https://leetcode-cn.com/problems/trapping-rain-water/
 *
 *  给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 */
class Solution {

    fun trap(height: IntArray): Int {

        var max = height[0]
        var maxIndex = 0
        for (i in 1..height.lastIndex) {
            val e = height[i]
            if (max < e) {
                max = e
                maxIndex = i
            }
        }
        return  _trap(height.sliceArray(0..maxIndex)) + _trap(height.sliceArray(maxIndex..height.lastIndex).reversedArray())
    }

    fun _trap(height: IntArray): Int {
        if (height.isEmpty()) return 0
        var result = 0


        var i = 0
        while (i < height.size) {
            if (height[i] == 0) {// 确定 i 的位置
                i++
                continue
            }

            val iValue = height[i]
            var j = -1
            var curRain = 0

            // 确定 j 的位置
            for (mj in i + 1 until height.size) {
                if (height[mj] >= iValue) {
                    j = mj
                    break
                }
                curRain +=  iValue - height[mj]
            }

            if (j > 0) {
                result += curRain
                i = j
            } else {
                i++
            }

        }

        return result
    }
}


fun main() {
    println(    Solution().trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1))
    )
}