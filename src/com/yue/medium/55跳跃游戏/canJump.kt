package com.yue.medium.`55跳跃游戏`

import kotlin.math.max

class Solution {
    fun canJump(nums: IntArray): Boolean {
        var can_reach = 0
        for (i in nums.indices) {
            if (i > can_reach) return false
            can_reach = max(can_reach, i + nums[i])
        }

        return true
    }


}

fun main() {
    println(
        Solution().canJump(intArrayOf(4,2,0,0,1,1,4,4,4,0,4,0))
    )
}