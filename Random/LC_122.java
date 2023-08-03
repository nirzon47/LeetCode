// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

public class LC_122 {
    public static int maxProfit(int[] prices) {
        int maxPrice = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            // Adding all the profits at each step and getting the max profit
            if (diff > 0) {
                maxPrice += diff;
            }
        }

        return maxPrice;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
