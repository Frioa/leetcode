package com.yue.hard.`887鸡蛋掉落`

/**
 * 未完成
 */
class Solution {

    val dp = HashMap<Int, Int>() // K , f
    fun superEggDrop(K: Int, N: Int): Int {
        if (K == 0) return N
        dp[0] = 1
        dp[1] = 1

        return _superEggDrop(K, N / 2, N)
    }

  private  fun _superEggDrop(curEgg: Int, curFloor: Int, preFloor: Int): Int {
        val leastEgg = initDp(curFloor)
        println("preFloor = $preFloor curFloor = $curFloor  leastEgg = $leastEgg ")

         if (leastEgg <= curEgg) {
             return initDp(curFloor)
        } else {
             return _superEggDrop(curEgg, (preFloor + curFloor) / 2, curFloor) + _superEggDrop(curEgg, (preFloor + curFloor) / 2 , curFloor)
        }
    }

   private fun initDp(N: Int): Int {
        if (N <= 1) return 1
        val nextN = N / 2
        var f = 1

        f += if (dp.containsKey(nextN)) dp[nextN]!!
        else initDp(nextN)

        return f
    }

}

fun main() {
    println(    Solution().superEggDrop(2, 4)
    )
}