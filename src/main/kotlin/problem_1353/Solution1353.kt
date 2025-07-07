package org.example.problem_198

import java.util.*

/**
 * You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.
 *
 * You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.
 *
 * Return the maximum number of events you can attend.
 */
object Solution1353 {
    fun maxEvents(events: Array<IntArray>): Int {
// Sort events by their start day
        events.sortBy { it[0] }

        val minHeap = PriorityQueue<Int>() // to store endDays of ongoing events
        var eventIndex = 0
        var attended = 0
        val lastDay = events.maxOf { it[1] }

        for (day in 1..lastDay) {
            // Add all events that start today
            while (eventIndex < events.size && events[eventIndex][0] == day) {
                minHeap.offer(events[eventIndex][1]) // push endDay
                eventIndex++
            }

            // Remove all events that have already expired
            while (minHeap.isNotEmpty() && minHeap.peek() < day) {
                minHeap.poll()
            }

            // Attend the event that ends the earliest (top of the heap)
            if (minHeap.isNotEmpty()) {
                minHeap.poll()
                attended++
            }
        }

        return attended
    }
}

fun main() {
    val result = Solution1353.maxEvents(
        arrayOf(
            intArrayOf(1, 4),  // Event A
            intArrayOf(2, 3),  // Event B
            intArrayOf(3, 4),  // Event C
            intArrayOf(1, 2)   // Event D
        )
    )

    println(result)
}