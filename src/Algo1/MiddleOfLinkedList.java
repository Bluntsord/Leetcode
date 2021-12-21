package Algo1;

public class MiddleOfLinkedList {


    public ListNode middleNode(ListNode head) {
        ListNode firstPointer = head;
        ListNode secondPointer = head;

        while (secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
        }
        return firstPointer;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
