package org.example.problem_3423

import kotlin.math.abs

/**
 * 3423. Maximum Difference Between Adjacent Elements in a Circular Array
 *
 * Given a circular array nums, find the maximum absolute difference between adjacent elements.
 *
 * Note: In a circular array, the first and last elements are adjacent.
 */
object Solution3423 {
    fun maxAdjacentDistance(nums: IntArray): Int {
        val n = nums.size
        var max = abs(nums[n - 1] - nums[0])

        for (i in 1 until nums.size - 1) {
            val leftDiff = abs(nums[i] - nums[i - 1])
            val rightDiff = abs(nums[i] - nums[i + 1])
            max = maxOf(max, maxOf(leftDiff, rightDiff))
        }

        return max
    }
}

fun main(args: Array<String>) {
    val result = Solution3423.maxAdjacentDistance(intArrayOf(-5, -10, -5))
    println("Result: $result")
}