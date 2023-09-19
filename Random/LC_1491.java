// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

public class LC_1491 {
    public static double average(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum = 0;

        // We find the sum of all elements, max of all elements and min of all elements
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum += num;
        }

        // Then we remove the max and min from the average formula and return
        return (sum - min - max) / (nums.length - 2);
    }

    public static void main(String[] args) {
        System.out.println(average(new int[]{4000, 3000, 1000, 2000}));
    }
}
