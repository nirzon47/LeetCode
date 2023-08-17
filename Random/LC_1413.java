// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/

public class LC_1413 {
    public static int minStartValue(int[] nums) {
        // Keeping track of the minimum prefix sum for every iteration
        int min = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }

        // If our number is negative, we need to add 1 to it so that it doesn't reach 0
        return 1 - min;
    }

    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{-3, 2, -3, 4, 2}));
    }
}
