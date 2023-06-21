// https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/

public class LC_2357 {
    public static int minimumOperations(int[] nums) {
        int sum = 0;

        // Constraints allow us to take a frequency array
        int[] freq = new int[101];

        // Updating freq[num] uniquely and taking the sum of all unique elements
        for (int num : nums) {
            if (freq[num] > 0 || num == 0) continue;
            freq[num]++;
            sum += num;
        }

        int count = 0;

        for (int n : freq) {
            // If freq[i] is more than 1, we subtract it from our sum and add count
            if (n >= 1) {
                sum -= n;
                count++;
            }
            if (sum == 0) break;
        }

        // Sum of all unique elements subtracted from the total of all unique elements are our steps
        return count;

    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 0, 3, 5};

        System.out.println(minimumOperations(nums));
    }
}
