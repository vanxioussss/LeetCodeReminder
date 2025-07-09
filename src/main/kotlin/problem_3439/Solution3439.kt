package org.example.problem_3439

/**
 * You are given an integer eventTime denoting the duration of an event, where the event occurs from time t = 0 to time t = eventTime.
 *
 * You are also given two integer arrays startTime and endTime, each of length n.
 * These represent the start and end time of n non-overlapping meetings, where the ith meeting occurs during the time [startTime[i], endTime[i]].
 *
 * You can reschedule at most k meetings by moving their start time while maintaining the same duration,
 * to maximize the longest continuous period of free time during the event.
 *
 * The relative order of all the meetings should stay the same and they should remain non-overlapping.
 *
 * Return the maximum amount of free time possible after rearranging the meetings.
 *
 * Note that the meetings can not be rescheduled to a time outside the event.
 */
object Solution3439 {
    fun maxFreeTime(eventTime: Int, k: Int, startTime: IntArray, endTime: IntArray): Int {
        val n = startTime.size
        val sum = IntArray(n + 1)

        // Precompute prefix sums of meeting durations
        for (i in 0 until n) {
            sum[i + 1] = sum[i] + (endTime[i] - startTime[i])
        }

        var res = 0

        for (i in (k - 1) until n) {
            val right = if (i == n - 1) eventTime else startTime[i + 1]
            val left = if (i == k - 1) 0 else endTime[i - k]

            val totalDuration = sum[i + 1] - sum[i - k + 1]
            res = maxOf(res, right - left - totalDuration)
        }

        return res
    }
}

fun main() {
    val result = Solution3439.maxFreeTime(20, 1, intArrayOf(2, 6, 12), intArrayOf(4, 8, 14))
    println(result)
}