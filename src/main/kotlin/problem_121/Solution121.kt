package org.example.problem_121

import kotlin.math.max
import kotlin.math.min

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
object Solution121 {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0

        for (price in prices) {
            minPrice = min(minPrice, price)

            val curProfit = price - minPrice
            maxProfit = max(curProfit, maxProfit)
        }

        return maxProfit
    }
}

fun main() {
    val result = Solution121.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))
    println(result)
}