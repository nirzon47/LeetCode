// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

public class DeleteTheMiddleNodeOfLinkedList {

    public static ListNode deleteMiddle(ListNode head) {
        // If the linked list is empty, return null
        if (head.next == null) return null;

        // Using the fast and slow pointer approach
        // Initializing the pointers
        ListNode slow = head;
        ListNode fast = head.next.next;

        // Run the loop until fast and fast.next is null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Puts the pointer after the middle pointer to the middle one
        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);

        System.out.println(deleteMiddle(head));
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
    }
}