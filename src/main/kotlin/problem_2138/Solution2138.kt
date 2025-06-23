package org.example.problem_2138

/**
 *A string s can be partitioned into groups of size k using the following procedure:
 *
 *     The first group consists of the first k characters of the string, the second group consists of the next k characters of the string, and so on. Each element can be a part of exactly one group.
 *     For the last group, if the string does not have k characters remaining, a character fill is used to complete the group.
 *
 * Note that the partition is done so that after removing the fill character from the last group (if it exists) and concatenating all the groups in order, the resultant string should be s.
 *
 * Given the string s, the size of each group k and the character fill, return a string array denoting the composition of every group s has been divided into, using the above procedure.
 */
object Solution2138 {
    fun divideString(s: String, k: Int, fill: Char): Array<String> {
        val result = mutableListOf<String>()
        var numOfGroup = s.length / k

        var currentString = s

        var firstIdx = 0
        while (numOfGroup > 0) {
            numOfGroup--
            val subString = s.substring(firstIdx, firstIdx + k)
            currentString = currentString.drop(k)
            result.add(subString)
            firstIdx += k
        }

        if (currentString.isNotEmpty()) {
            while (currentString.length < k) {
                currentString += fill
            }

            result.add(currentString)
        }

        return result.toTypedArray()
    }

    fun divideStringOptimized(s: String, k: Int, fill: Char): Array<String> {
        val result = mutableListOf<String>()
        var i = 0

        while (i < s.length) {
            val end = minOf(i + k, s.length)
            val part = StringBuilder(s.substring(i, end))
            while (part.length < k) {
                part.append(fill)
            }
            result.add(part.toString())
            i += k
        }

        return result.toTypedArray()
    }
}

fun main(args: Array<String>) {
    val result = Solution2138.divideStringOptimized("abcdefghij", 3, 'x')
    println("Result: ${result.joinToString()}")
}