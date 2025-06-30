package org.example.problem_24

import org.example.ListNode

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 */
object Solution24 {
    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var prev = dummy

        while (prev.next != null && prev.next?.next != null) {
            val first = prev.next
            val second = first?.next

            first?.next = second?.next
            second?.next = first
            prev.next = second

            prev = first!!
        }

        return dummy.next
    }
}

fun main() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4)
            }
        }
    }
    val result = Solution24.swapPairs(head)
    println(result)
}