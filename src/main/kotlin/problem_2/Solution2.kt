package org.example.problem_2

import org.example.ListNode

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
object Solution2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var head1 = l1
        var head2 = l2

        val dummy = ListNode(0)
        var result = dummy
        var carry = 0

        while (head1 != null || head2 != null) {
            val x = head1?.`val` ?: 0
            val y = head2?.`val` ?: 0

            val sum = x + y + carry
            carry = sum / 10

            result.next = ListNode(sum % 10)
            result = result.next!!

            head1 = head1?.next
            head2 = head2?.next
        }

        if (carry > 0) {
            result.next = ListNode(carry)
        }

        return dummy.next
    }
}

fun main() {
    val l1 = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(3)
        }
    }

    val l2 = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4)
        }
    }

    val result = Solution2.addTwoNumbers(l1, l2)
    println(result)
}