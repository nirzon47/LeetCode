// https://leetcode.com/problems/reverse-linked-list/

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        // Make a new node that points to nothing as of now since
        // the element before the current head is null
        ListNode prev = null;
        // A node that contains the current head
        ListNode current = head;

        // Iterate until current is not null
        while (current != null) {
            // Create a temporary node to hold current.next so the link doesn't get lost
            ListNode temp = current.next;
            // Put the prev node as the next node of the current node
            current.next = prev;
            // Put prev as the current node
            prev = current;
            // The next node we held is our current node
            current = temp;
        }
        // The Linked List now starts with prev as the head
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);

        System.out.println(reverseList(head));
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
