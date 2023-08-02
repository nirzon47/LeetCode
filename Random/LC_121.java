// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class LC_121 {
    public static int maxProfit(int[] prices) {
        /*
         * Intuition:
         * We look for the smallest number first and then any number that is bigger than that is our max,
         * and at every point we get a bigger number, we subtract the max from the min
         * If there is a smaller number, we replace our min and put the max as the same
         * and repeat
         */
        int res = 0, min = Integer.MAX_VALUE, max = 0;

        for (int price : prices) {
            if (min > price) {
                min = price;
                max = min;
            }

            max = Math.max(max, price);
            res = Math.max(max - min, res);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
