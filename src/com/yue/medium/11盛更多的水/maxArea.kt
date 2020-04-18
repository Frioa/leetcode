package com.yue.medium.`11盛更多的水`

import kotlin.math.min

class Solution {
    fun maxArea(height: IntArray): Int {
        var low = 0
        var hei = height.lastIndex

        var max = -1
        while (low < hei) {
            val curArea = min(height[low], height[hei]) * (hei - low)
            if (curArea > max) max = curArea

            if (height[low] < height[hei]) low++
            else hei --
        }

        return max

    }


}