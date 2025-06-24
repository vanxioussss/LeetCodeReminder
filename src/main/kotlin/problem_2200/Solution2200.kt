package org.example.problem_2200

/**
 * You are given a 0-indexed integer array nums and two integers key and k.
 * A k-distant index is an index i of nums for which there exists at least one index j
 * such that |i - j| <= k and nums[j] == key.
 *
 * Return a list of all k-distant indices sorted in increasing order.
 */
object Solution2200 {
    fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
        val result = mutableSetOf<Int>()
        val keyIndices = nums.indices.filter { nums[it] == key }

        for (index in keyIndices) {
            val start = (index - k).coerceAtLeast(0)
            val end = (index + k).coerceAtMost(nums.lastIndex)
            for (i in start..end) {
                result.add(i)
            }
        }

        return result.sorted()
    }
}

fun main(args: Array<String>) {
    val result = Solution2200.findKDistantIndices(intArrayOf(3, 4, 9, 1, 3, 9, 5), key = 9, k = 1)
    println("Result: ${result.joinToString()}")
}