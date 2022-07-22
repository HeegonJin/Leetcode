package d220721.q92;

public class Solution {
    static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++)
            prev = prev.next;

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode forw = curr.next;
            curr.next = forw.next;
            forw.next = prev.next;
            prev.next = forw;
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(-3, new ListNode(-2, new ListNode(3, new ListNode(-5, new ListNode(3, new ListNode(4, new ListNode(-4)))))));
        System.out.println(reverseBetween(listNode, 5, 7));
    }
}

