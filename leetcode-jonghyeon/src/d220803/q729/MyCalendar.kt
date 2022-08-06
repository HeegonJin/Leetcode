package leetcode.d220803.q729


class MyCalendar {

    class Node(var start: Int, var end: Int) {
        var left: Node? = null
        var right: Node? = null
    }

    var root: Node? = null
    fun insert(parent: Node?, s: Int, e: Int): Boolean {
        if (parent!!.start >= e) {
            return if (parent.left == null) {
                parent.left = Node(s, e)
                true
            } else {
                insert(parent.left, s, e)
            }
        } else if (parent!!.end <= s) {
            return if (parent.right == null) {
                parent.right = Node(s, e)
                true
            } else {
                insert(parent.right, s, e)
            }
        }
        return false
    }

    fun book(start: Int, end: Int): Boolean {
        return if (root == null) {
            root = Node(start, end)
            true
        } else {
            insert(root, start, end)
        }
    }
}