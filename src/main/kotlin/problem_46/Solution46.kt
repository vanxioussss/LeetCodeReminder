package org.example.problem_46

/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 */
object Solution46 {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun backtrack(path: MutableList<Int>, used: BooleanArray) {
            if (path.size == nums.size) {
                result.add(ArrayList(path)) // Found a permutation, add a copy
                return
            }

            for (i in nums.indices) {
                if (used[i]) continue // Skip if already used

                // Choose
                used[i] = true
                path.add(nums[i])

                // Explore
                backtrack(path, used)

                // Unchoose (backtrack)
                path.removeAt(path.size - 1)
                used[i] = false
            }
        }

        backtrack(mutableListOf(), BooleanArray(nums.size))
        return result
    }
}

fun main(args: Array<String>) {
    val result = Solution46.permute(intArrayOf(1, 2, 3))
    println("Result: ${result.joinToString()}")
}