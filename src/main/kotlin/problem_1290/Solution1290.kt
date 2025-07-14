package org.example.problem_1290

import org.example.ListNode

/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 * The most significant bit is at the head of the linked list.
 */
object Solution1290 {
    fun getDecimalValue(head: ListNode?): Int {
        var num = 0
        var cur = head

        while (cur != null) {
            num = (num shl 1) or cur.`val`
            cur = cur.next
        }

        return num
    }
}

fun main() {
    val head = ListNode(1).apply {
        next = ListNode(0).apply {
            next = ListNode(1)
        }
    }
    val result = Solution1290.getDecimalValue(head)
    println(result)
}