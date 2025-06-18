package org.example.problem_2966

import kotlin.math.abs

/**
 *You are given an integer array nums of size n where n is a multiple of 3 and a positive integer k.
 *
 * Divide the array nums into n / 3 arrays of size 3 satisfying the following condition:
 *
 *   -  The difference between any two elements in one array is less than or equal to k.
 *
 * Return a 2D array containing the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.
 */

// [2,2,2,2,4,5]
object Solution2966 {
    // My submission
    fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
        val sortedArray = nums.sortedArray()
        val result = mutableListOf<IntArray>()

        for (i in 0 until nums.size step 3) {
            val subArray = sortedArray.sliceArray(i..i + 2)
            val maxAbs =
                maxOf(abs(subArray[1] - subArray[0]), abs(subArray[1] - subArray[2]), abs(subArray[2] - subArray[0]))

            if (maxAbs > k) {
                result.clear()
                break
            }

            result.add(subArray)
        }

        return result.toTypedArray()
    }

    // Optimize
    fun divideArrayOptimized(nums: IntArray, k: Int): Array<IntArray> {
        val sorted = nums.sortedArray()
        val result = mutableListOf<IntArray>()

        for (i in sorted.indices step 3) {
            if (i + 2 >= sorted.size) return emptyArray() // Not enough elements to form a triplet

            if (sorted[i + 2] - sorted[i] > k) return emptyArray() // Max diff is between first and last in sorted triplet

            result.add(intArrayOf(sorted[i], sorted[i + 1], sorted[i + 2]))
        }

        return result.toTypedArray()
    }
}

fun main(args: Array<String>) {
    val result = Solution2966.divideArray(intArrayOf(17, 15, 20, 16, 15, 10, 20, 19, 17), 2)
    result.forEach { outsideArray ->
        print("[")
        outsideArray.forEach {
            print("$it,")
        }
        print("]\n")
    }
}

