package org.example.problem_123

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
object Solution123 {
    fun maxProfit(prices: IntArray): Int {
        var buy1 = Int.MIN_VALUE
        var sell1 = 0
        var buy2 = Int.MIN_VALUE
        var sell2 = 0

        for (price in prices) {
            buy1 = maxOf(buy1, -price)         // Best after buying first stock
            sell1 = maxOf(sell1, buy1 + price) // Best after selling first stock
            buy2 = maxOf(buy2, sell1 - price)  // Best after buying second stock
            sell2 = maxOf(sell2, buy2 + price) // Best after selling second stock
        }

        return sell2
    }
}

fun main() {
    val result = Solution123.maxProfit(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4))
    println(result)
}