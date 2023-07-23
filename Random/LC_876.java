// https://leetcode.com/problems/middle-of-the-linked-list/

public class LC_876 {
    public static ListNode middleNode(ListNode head) {
        // Assigning fast and slow pointers
        // When the fast pointers will stop is where the slow pointer will point at the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Returning the slow pointer head
        return slow;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 1;
        l1.next = new ListNode();
        l1.next.val = 2;
        l1.next.next = new ListNode();
        l1.next.next.val = 3;

        System.out.println(middleNode(l1).val);
    }

    public static class ListNode {
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
