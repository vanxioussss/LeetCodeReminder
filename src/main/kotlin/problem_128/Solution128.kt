package org.example.problem_128

import kotlin.math.max

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 */
object Solution128 {
    fun longestConsecutive(nums: IntArray): Int {
        val set = mutableSetOf<Int>()

        for (num in nums) {
            set.add(num)
        }

        var longest = 0
        for (num in set) {
            if (!set.contains(num - 1)) {
                var length = 1
                while (num + length in set) {
                    length++
                }
                longest = max(length, longest)
            }
        }

        return longest
    }
}

fun main(args: Array<String>) {
    val result = Solution128.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2))
    println(result)
}