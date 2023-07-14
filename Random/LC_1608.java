// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

public class LC_1608 {
    public static int specialArray(int[] nums) {
        // Making the range of our binary search from 0 to the total length of our array
        // since the answer of the solution cannot exceed it
        int left = 0, right = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            // Counting the number of elements greater than mid
            for (int num : nums) {
                if (num >= mid) {
                    count++;
                }
            }

            // Performing regular binary search with mid and count
            if (mid == count) {
                return mid;
            } else if (mid > count) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Throwaway return statement to make the code work
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 4, 3, 0, 4};
        System.out.println(specialArray(nums));
    }
}
