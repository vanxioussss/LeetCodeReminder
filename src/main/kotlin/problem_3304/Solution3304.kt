package org.example.problem_3304

/**
 * Alice and Bob are playing a game. Initially, Alice has a string word = "a".
 *
 * You are given a positive integer k.
 *
 * Now Bob will ask Alice to perform the following operation forever:
 *
 *  -  Generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word.
 *
 * For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".
 *
 * Return the value of the kth character in word, after enough operations have been done for word to have at least k characters.
 *
 * Note that the character 'z' can be changed to 'a' in the operation.
 */
object Solution3304 {
    fun getKthChar(k: Int): Char {
        var length = 1
        var depth = 0

        while (length < k) {
            length *= 2
            depth++
        }

        var index = k
        var shift = 0
        var currentLength = length

        while (depth > 0) {
            val half = currentLength / 2
            if (index > half) {
                index -= half
                shift++
            }
            currentLength = half
            depth--
        }

        // Final character is 'a' + shift count (wrap around 'z' to 'a')
        return ((('a'.code + shift - 'a'.code) % 26) + 'a'.code).toChar()
    }
}

fun main() {
    val result = Solution3304.getKthChar(5)
    println(result)
}