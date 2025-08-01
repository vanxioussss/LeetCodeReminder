package org.example.problem_202

/**
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * - Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * - Those numbers for which this process ends in 1 are happy.
 *
 * Return true if n is a happy number, and false if not.
 */
object Solution202 {
    fun isHappy(n: Int): Boolean {
        val seen = mutableSetOf<Int>()
        var current = n

        while (current !in seen) {
            seen.add(current)

            var sum = 0
            var temp = current
            while (temp > 0) {
                val digit = temp % 10
                sum += digit * digit
                temp /= 10
            }

            if (sum == 1) return true
            current = sum
        }

        return false
    }
}

fun main() {
    val result = Solution202.isHappy(19)
    println(result)
}