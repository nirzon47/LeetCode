// https://leetcode.com/problems/richest-customer-wealth/

public class LC_1672 {
    public static int maximumWealth(int[][] accounts) {
        // I mean... Do I even need to explain anything?
        int maxSum = 0;
        for (int[] r : accounts) {
            int sum = 0;
            for (int e : r) {
                sum += e;
            }
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};

        System.out.println(maximumWealth(accounts));
    }
}
