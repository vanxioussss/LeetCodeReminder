package org.example.problem_3440

/**
 * You are given an integer eventTime denoting the duration of an event.
 * You are also given two integer arrays startTime and endTime, each of length n.
 *
 * These represent the start and end times of n non-overlapping meetings that occur during the event between time t = 0 and time t = eventTime,
 * where the ith meeting occurs during the time [startTime[i], endTime[i]].
 *
 * You can reschedule at most one meeting by moving its start time while maintaining the same duration,
 * such that the meetings remain non-overlapping, to maximize the longest continuous period of free time during the event.
 *
 * Return the maximum amount of free time possible after rearranging the meetings.
 *
 * Note that the meetings can not be rescheduled to a time outside the event and they should remain non-overlapping.
 *
 * Note: In this version, it is valid for the relative ordering of the meetings to change after rescheduling one meeting.
 */
object Solution3440 {
    fun maxFreeTime(eventTime: Int, startTime: IntArray, endTime: IntArray): Int {
        val n = startTime.size
        val q = BooleanArray(n)

        var t1 = 0
        var t2 = 0

        // Forward pass (left to right)
        for (i in 0 until n) {
            val duration = endTime[i] - startTime[i]
            if (duration <= t1) {
                q[i] = true
            }
            val prevEnd = if (i == 0) 0 else endTime[i - 1]
            t1 = maxOf(t1, startTime[i] - prevEnd)
        }

        // Backward pass (right to left)
        for (i in 0 until n) {
            val idx = n - 1 - i
            val duration = endTime[idx] - startTime[idx]
            if (duration <= t2) {
                q[idx] = true
            }
            val nextStart = if (i == 0) eventTime else startTime[n - i]
            t2 = maxOf(t2, nextStart - endTime[idx])
        }

        // Calculate max free time
        var res = 0
        for (i in 0 until n) {
            val left = if (i == 0) 0 else endTime[i - 1]
            val right = if (i == n - 1) eventTime else startTime[i + 1]
            val duration = endTime[i] - startTime[i]

            res = if (q[i]) {
                maxOf(res, right - left)
            } else {
                maxOf(res, right - left - duration)
            }
        }

        return res
    }
}

fun main() {
    val result = Solution3440.maxFreeTime(5, intArrayOf(1, 3), intArrayOf(2, 5))
    println(result)
}