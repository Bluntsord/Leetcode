package LeetCodePatterns;

public class LinkedListCycle {


    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode tortoise = head;
        ListNode hare = head.next;
        while (tortoise != hare) {
            if (hare == null || tortoise == null) {
                return false;
            }

            tortoise = tortoise.next;
            hare = hare.next == null? null: hare.next.next;
        }

        return true;
    }
}
