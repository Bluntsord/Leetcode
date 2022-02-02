package LeetCodePatterns;

public class EntranceToCycle {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode getIntersectNode(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head.next;

        while (tortoise != hare) {
            if (hare == null || tortoise == null) {
                return hare;
            }

            tortoise = tortoise.next;
            hare = hare.next == null? null: hare.next.next;
        }

        return hare;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = getIntersectNode(head);

        //Slow down the hare to same speed as the tortoise to get the entrance
        while (tortoise != hare) {
            if (hare == null || tortoise == null) {
                return hare;
            }

            tortoise = tortoise.next;
            hare = hare.next;
        }

        return hare;
    }
}
