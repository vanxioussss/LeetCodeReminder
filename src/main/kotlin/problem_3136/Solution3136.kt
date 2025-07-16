package org.example.problem_3136

/**
 * A word is considered valid if:
 *
 * - It contains a minimum of 3 characters.
 * - It contains only digits (0-9), and English letters (uppercase and lowercase).
 * - It includes at least one vowel.
 * - It includes at least one consonant.
 *
 * You are given a string word.
 *
 * Return true if word is valid, otherwise, return false.
 *
 * Notes:
 *
 * - 'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
 * - A consonant is an English letter that is not a vowel.
 *
 */
object Solution3136 {
    fun isValid(word: String): Boolean {
        if (word.length < 3) {
            return false
        }

        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        var hasVowel = false
        var hasConsonant = false

        for (char in word) {
            if (!char.isLetterOrDigit()) {
                return false
            }

            if (char.isLetter()) {
                val lowerChar = char.lowercaseChar()
                if (lowerChar in vowels) {
                    hasVowel = true
                } else {
                    hasConsonant = true
                }
            }
        }

        return hasVowel && hasConsonant
    }
}

fun main() {
    val result = Solution3136.isValid("234Adas")
    println(result)
}