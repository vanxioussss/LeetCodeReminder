package org.example.problem_3046

/**
 * You are given an integer array nums of even length. You have to split the array into two parts nums1 and nums2 such that:
 *
 * - nums1.length == nums2.length == nums.length / 2.
 * - nums1 should contain distinct elements.
 * - nums2 should also contain distinct elements.
 *
 * Return true if it is possible to split the array, and false otherwise.
 */
object Solution3046 {
    fun isPossibleToSplit(nums: IntArray): Boolean {
        val freqMap = mutableMapOf<Int, Int>()

        for (num in nums) {
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }

        for ((_, freq) in freqMap) {
            if (freq > 2) {
                return false
            }
        }

        return true
    }
}

fun main() {
    val result = Solution3046.isPossibleToSplit(intArrayOf(1, 1, 2, 2, 3, 4))
    println(result)
}