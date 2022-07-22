package d220722.q86;


public class Solution {

    static ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode  temp = new ListNode(0, head);
        ListNode prev = temp;

        while(prev.next.val < x){
            prev = prev.next;
            if (prev.next == null){
                return temp.next;
            }
        }

        ListNode curr = prev.next;

        while (curr.next!=null){
            if (curr.next.val < x){
                ListNode inserted = new ListNode(curr.next.val);
                inserted.next = prev.next;
                prev.next = inserted;
                prev = prev.next;
                curr.next = curr.next.next;
            } else{
                curr = curr.next;
            }
        }

        return temp.next;

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
//        ListNode head = new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2))))));
        ListNode head = new ListNode(1);
//        int x = 3;
        int x = 2;

        System.out.println(partition(head,x));
    }
}
