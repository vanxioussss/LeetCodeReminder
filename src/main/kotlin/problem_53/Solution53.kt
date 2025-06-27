package org.example.problem_53

import kotlin.math.max

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */
object Solution53 {
    fun maxSubArray(nums: IntArray): Int {
        var curSum = 0
        var res = nums[0]

        for (num in nums) {
            curSum = max(curSum, 0)
            curSum += num
            res = max(curSum, res)
        }

        return res
    }
}

fun main(args: Array<String>) {
    val result = Solution53.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))
    println(result)
}