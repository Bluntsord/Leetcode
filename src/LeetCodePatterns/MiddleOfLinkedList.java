package LeetCodePatterns;

public class MiddleOfLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head.next;

        while (hare != null) {
            hare = hare.next == null? null: hare.next.next;
            tortoise = tortoise.next;
        }

        return tortoise;
    }
}
