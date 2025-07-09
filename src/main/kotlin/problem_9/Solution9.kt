package org.example.problem_9

object Solution9 {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        var reversed = 0
        var original = x

        while (original > 0) {
            reversed = reversed * 10 + original % 10
            original /= 10
        }

        return reversed == x
    }
}

fun main() {
    val result = Solution9.isPalindrome(1221)
    println(result)
}