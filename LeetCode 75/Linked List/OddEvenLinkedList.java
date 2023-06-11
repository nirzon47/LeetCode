// https://leetcode.com/problems/odd-even-linked-list/

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        // If there is nothing in the linked list, return well, nothing
        if (head == null) return null;

        // Initialize odd as the first node, even as the second node
        ListNode odd = head;
        ListNode even = head.next;
        // Reserve another list for having the reference of the first head of the even list
        ListNode evenHead = even;

        // Go until a node's value is null and the next address is also null
        while (even != null && even.next != null) {
            // Increase odd and even's node by 2
            odd.next = odd.next.next;
            even.next = even.next.next;

            // Put the changes back in their current head
            odd = odd.next;
            even = even.next;
        }
        // Append evenHead's head to the node in odd's head,
        // so it's the odd list followed by the even list
        odd.next = evenHead;
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

        System.out.println(oddEvenList(head));
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
