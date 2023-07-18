// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

// Check LC_410 for explanation. Same code.

public class LC_1011 {
    public static boolean isPossible(int[] weights, int limit, int days) {
        int count = 1, sum = 0;
        for (int weight : weights) {
            sum += weight;
            if (sum > limit) {
                count++;
                sum = weight;
            }
        }

        return count <= days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(weights, mid, days)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }
}
