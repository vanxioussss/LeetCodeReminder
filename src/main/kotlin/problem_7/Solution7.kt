package org.example.problem_7

import kotlin.math.abs

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */
object Solution7 {
    fun reverse(x: Int): Int {
        var result = 0
        var num = abs(x)

        while (num > 0) {
            val digit = num % 10
            num /= 10

            if (result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && digit > 7)) {
                return 0
            }

            if (result < Int.MIN_VALUE / 10) {
                return 0
            }

            result = result * 10 + digit
        }

        return if (x < 0) {
            -result
        } else {
            result
        }
    }
}

fun main() {
    val result = Solution7.reverse(1534236469)
    println(result)
}