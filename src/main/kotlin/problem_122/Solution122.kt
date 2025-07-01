package org.example.problem_122

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 */
object Solution122 {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += (prices[i] - prices[i - 1])
            }
        }

        return maxProfit
    }
}

fun main() {
    val result = Solution122.maxProfit(intArrayOf(1, 2, 3, 4, 5))
    println(result)
}