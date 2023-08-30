// https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/

public class LC_2335 {
    public static int fillCups(int[] nums) {
        // Heap solution is more brain-dead. This is a math solution.
        int sum = 0, max = Integer.MIN_VALUE;

        // We take the sum and max of all elements
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        // We can have two answers, one of them being the
        // number of switches to make the maximum cup normal.
        // The other being switching two cups until they are same, taking the whole process the sum / 2.
        // We can't have half-switches, so we are doing a ceil division.
        return Math.max((sum + 1) / 2, max);
    }

    public static void main(String[] args) {
        System.out.println(fillCups(new int[]{1, 4, 2}));
    }
}
