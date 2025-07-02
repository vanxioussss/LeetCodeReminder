package org.example.problem_347

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 */
object Solution347 {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // Step 1: Count frequencies
        val freqMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }

        // Step 2: Initialize buckets. Index = frequency.
        val buckets = Array<MutableList<Int>>(nums.size + 1) { mutableListOf() }
        for ((num, freq) in freqMap) {
            buckets[freq].add(num)
        }

        // Step 3: Traverse buckets from high to low and collect top K elements
        val result = mutableListOf<Int>()
        for (i in buckets.size - 1 downTo 0) {
            for (num in buckets[i]) {
                result.add(num)
                if (result.size == k) return result.toIntArray()
            }
        }

        return result.toIntArray()
    }
}

fun main() {
    val result = Solution347.topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), k = 2)
    println(result.joinToString())
}