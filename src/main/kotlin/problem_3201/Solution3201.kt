package org.example.problem_3201

/**
 * You are given an integer array nums.
 *
 * A subsequence sub of nums with length x is called valid if it satisfies:
 *
 *  - (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
 *
 * Return the length of the longest valid subsequence of nums.
 *
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 */
object Solution3201 {
    fun maximumLength(nums: IntArray): Int {
        var evenCount = 0
        var oddCount = 0
        var alternateCount = 0
        var parity = -1

        for (i in nums) {
            if (i % 2 == 0) {
                evenCount++
                if (parity == 1 || parity == -1) {
                    alternateCount++
                }
            } else {
                oddCount++
                if (parity == 0 || parity == -1) {
                    alternateCount++
                }
            }

            parity = i % 2
        }

        return alternateCount.coerceAtLeast(evenCount.coerceAtLeast(oddCount))
    }
}

fun main() {
    val result = Solution3201.maximumLength(intArrayOf(2, 3, 4, 5, 6, 7))
    println(result)
}