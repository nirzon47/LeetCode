// https://leetcode.com/problems/single-element-in-a-sorted-array/

public class LC_540 {
    public static int singleNonDuplicate(int[] nums) {
        // Performing binary search
        int left = 0, right = nums.length - 1, res = -1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the current mid-point is even, the current number and the next number
            // must be equal.
            // If the current mid-point is odd, the current number should be equal to the previous number
            // If these conditions do satisfy, we are in the clear of the left half, so we move to the right half
            // and vice versa
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                    (mid % 2 != 0 && nums[mid] == nums[mid - 1])) {
                res = nums[left];
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}
