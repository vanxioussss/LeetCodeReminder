package org.example.problem_3

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 */
object Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        val seen = mutableSetOf<Char>()
        var left = 0
        var maxLength = 0
        var currentLength = 0

        for (right in s.indices) {
            if (s[right] in seen) {
                seen.remove(s[right])
                currentLength--
                left++
            }

            seen.add(s[right])
            currentLength++
            maxLength = maxOf(maxLength, currentLength)
        }

        return maxLength
    }
}

fun main() {
    val result = Solution3.lengthOfLongestSubstring("abcabcbb")
    println(result)
}