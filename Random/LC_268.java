// https://leetcode.com/problems/missing-number/

public class LC_268 {
    public static int missingNumber(int[] nums) {

        // Adding up all the numbers in the array
        int sum = 0, len = nums.length;
        for (int num : nums) {
            sum += num;
        }

        // Using the n(n+1)/2 formula and subtracting 'sum' from that to get the missing element
        return (len * (len + 1)) / 2 - sum;

        /*
        Hashing Solution
        O(n) O(n)

        int[] freq = new int[nums.length + 1];

        for (int i = 0; i < freq.length - 1; i++) {
            freq[nums[i]]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) return i;
        }

        return -1;

         */
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        System.out.println(missingNumber(nums));
    }
}
