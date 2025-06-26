package org.example.problem_2311

/**
 *  You are given a binary string s and a positive integer k.
 *
 *  Return the length of the longest subsequence of s that makes up a binary number less than or equal to k.
 *
 *  Note:
 *
 *    - The subsequence can contain leading zeroes.
 *    - The empty string is considered to be equal to 0.
 *    - A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
 */
object Solution2311 {
    fun longestSubsequence(s: String, k: Int): Int {
        var count = 0
        var value = 0L // use Long to avoid overflow
        var power = 0

        for (i in s.length - 1 downTo 0) {
            val bit = s[i]

            if (bit == '0') {
                count++
            } else {
                if (power < 32) {
                    val addition = 1L shl power
                    if (value + addition <= k) {
                        value += addition
                        count++
                    }
                }
            }

            power++
        }

        return count
    }
}

fun main(args: Array<String>) {
    val result = Solution2311.longestSubsequence("1001010", k = 5)
    println(result)
}