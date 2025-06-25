package org.example.problem_2040

/**
 *  Given two sorted 0-indexed integer arrays nums1 and nums2 as well as an integer k,
 *  return the kth (1-based) smallest product of nums1[i] * nums2[j]
 *  where 0 <= i < nums1.length and 0 <= j < nums2.length.
 */
object Solution2040 {
    fun kthSmallestProduct(nums1: IntArray, nums2: IntArray, k: Long): Long {
        nums1.sort()
        nums2.sort()

        // Define search space for possible product values
        var low = -1_000_000_000L * 1_000_000_000L
        var high = 1_000_000_000L * 1_000_000_000L

        while (low < high) {
            val mid = low + (high - low) / 2

            // Count how many products ≤ mid
            val count = countLessOrEqual(nums1, nums2, mid)

            if (count < k) {
                // Not enough values ≤ mid → we need larger product
                low = mid + 1
            } else {
                // mid might be our answer → try smaller
                high = mid
            }
        }

        return low // smallest value where count ≥ k
    }

    // Count how many nums1[i] * nums2[j] <= target
    fun countLessOrEqual(nums1: IntArray, nums2: IntArray, target: Long): Long {
        var count = 0L
        for (a in nums1) {
            count += countValidPairs(a.toLong(), nums2, target)
        }
        return count
    }

    // For fixed a = nums1[i], count valid nums2[j] s.t. a * nums2[j] <= target
    fun countValidPairs(a: Long, nums2: IntArray, target: Long): Long {
        if (a > 0) {
            // binary search rightmost index where nums2[j] <= target / a
            var left = 0
            var right = nums2.size
            while (left < right) {
                val mid = (left + right) / 2
                if (a * nums2[mid] <= target) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            return left.toLong() // number of valid products
        } else if (a < 0) {
            // binary search leftmost index where nums2[j] >= ceil(target / a)
            var left = 0
            var right = nums2.size
            while (left < right) {
                val mid = (left + right) / 2
                if (a * nums2[mid] <= target) {
                    right = mid
                } else {
                    left = mid + 1
                }
            }
            return (nums2.size - right).toLong()
        } else {
            // a == 0 ⇒ product is always 0
            return if (target >= 0) nums2.size.toLong() else 0L
        }
    }
}

fun main(args: Array<String>) {
    val result = Solution2040.kthSmallestProduct(intArrayOf(2, 5), intArrayOf(3, 4), k = 2)
    println("Result: $result")
}