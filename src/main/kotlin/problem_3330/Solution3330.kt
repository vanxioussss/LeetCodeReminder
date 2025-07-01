package org.example.problem_3330

/**
 * Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for too long,
 * resulting in a character being typed multiple times.
 *
 * Although Alice tried to focus on her typing, she is aware that she may still have done this at most once.
 *
 * You are given a string word, which represents the final output displayed on Alice's screen.
 *
 * Return the total number of possible original strings that Alice might have intended to type.
 */
object Solution3330 {
    fun possibleStringCount(word: String): Int {
        var count = 1
        for (i in 1 until word.length) {
            if (word[i - 1] == word[i]) {
                count++
            }
        }

        return count
    }
}

fun main() {
    val result = Solution3330.possibleStringCount("ere")
    println(result)
}