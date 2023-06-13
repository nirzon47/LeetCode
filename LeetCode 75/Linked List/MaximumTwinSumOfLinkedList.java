// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

public class MaximumTwinSumOfLinkedList {

    public static int pairSum(ListNode head) {
        // Using the slow and fast pointer technique to get to the middle element
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Making a prev node to reverse the second half of the linked list
        ListNode prev = null;

        // While the middle node we found earlier is not null, reverse the nodes
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // Resetting fast because it was already declared, and initializing our result variable
        fast = head;
        int res = 0;

        // Go until our now reverse-linked list is not null,
        // Find out the sum of their values and check which is bigger
        while (prev != null) {
            int sum = prev.val + fast.val;
            res = Math.max(res, sum);
            prev = prev.next;
            fast = fast.next;
        }

        // Return the largest twin
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);

        System.out.println(pairSum(head));
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
