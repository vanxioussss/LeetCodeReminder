package org.example.problem_594

/**
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 *
 * Given an integer array nums, return the length of its longest harmonious subsequence
 * among all its possible subsequences.
 */
object Solution594 {
    fun findLHS(nums: IntArray): Int {
        var max = 0
        nums.sort()
        println(nums.joinToString())
        var left = 0


        for (right in 1 until nums.size) {
            while (nums[right] - nums[left] > 1) {
                left++
            }

            if (nums[right] - nums[left] == 1) {
                max = maxOf(max, right - left + 1)
            }
        }

        return max
    }

    fun findLHS2(nums: IntArray): Int {
        val freqMap = mutableMapOf<Int, Int>()

        // Count frequency of each number
        for (num in nums) {
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }

        var maxLength = 0

        // Check each number's neighbor (num + 1)
        for ((num, count) in freqMap) {
            if (freqMap.containsKey(num + 1)) {
                val currentLength = count + freqMap[num + 1]!!
                maxLength = maxOf(maxLength, currentLength)
            }
        }

        return maxLength
    }
}

fun main() {
    val result = Solution594.findLHS(intArrayOf(1, 2, 2, 1))
    println(result)
}