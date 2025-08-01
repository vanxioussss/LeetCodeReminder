package org.example

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return "$`val`${next?.let { " -> $it" } ?: ""}"
    }
}