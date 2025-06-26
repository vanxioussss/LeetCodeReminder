package org.example.problem_1

/**
 *  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 *  You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 *  You can return the answer in any order.
 */
object Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            }
            map[nums[i]] = i
        }

        return intArrayOf()
    }
}

fun main(args: Array<String>) {
    val result = Solution1.twoSum(nums = intArrayOf(2, 7, 11, 15), target = 9)
    println(result.joinToString())
}