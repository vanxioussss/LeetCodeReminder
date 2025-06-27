package org.example.problem_69

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 * - For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 */
object Solution69 {
    fun mySqrt(x: Int): Int {
        var left = 0
        var right = x
        var result = 0

        while (left <= right) {
            val mid = left + (right - left) / 2
            val square = mid.toLong() * mid

            if (square == x.toLong()) {
                return mid
            } else if (square < x.toLong()) {
                result = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val result = Solution69.mySqrt(2147395599)
    println(result)
}