package com.yue.medium.`56 合并区间`

class Solution {
    lateinit var resArray: ArrayList<IntArray>
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty() || intervals.size == 1) return intervals
        intervals.sortWith(Comparator { t, t2 -> if (t[0] - t2[0] == 0) t[1] - t2[1] else t[0] - t2[0] })
        resArray = ArrayList()
        resArray.add(intervals[0])

        for (ele in intervals) {
            if (resArray[resArray.lastIndex][1] >= ele[1]) continue  // ele 区间范围太小
            if (resArray[resArray.lastIndex][1] < ele[0]) resArray.add(ele) // ele 区间范文过大
            else resArray[resArray.lastIndex][1] = ele[1] // 合并区间
        }

        return resArray.toTypedArray()
    }
}
