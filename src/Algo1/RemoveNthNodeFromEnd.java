package Algo1;

public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
        firstNode.next = secondNode;
//        secondNode.next = thirdNode;
        ListNode pointer = firstNode;
        removeNthNodeFromEnd.printNodes(firstNode);
        removeNthNodeFromEnd.removeNthFromEnd(firstNode, 2);
        System.out.println("=========================");
        removeNthNodeFromEnd.printNodes(firstNode);

    }

    public void printNodes(ListNode pointer) {
        while (pointer != null) {
            System.out.println(pointer);
            pointer = pointer.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode firstPointer = head;
        ListNode secondPointer = head;

        for (int i = 0; i < n; i++) {
            if (secondPointer == null) {
                break;
            }
            secondPointer = secondPointer.next;
        }

        if (secondPointer == null) {
            return head.next;
        }

        while (secondPointer != null && secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        firstPointer.next = firstPointer.next.next;
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        public String toString() {
            return Integer.toString(val);
        }
    }
}
