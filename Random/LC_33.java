// https://leetcode.com/problems/search-in-rotated-sorted-array/

public class LC_33 {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // Doing normal binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // If our mid is >= to left, that means we are at the first half and our section is sorted
            if (nums[left] <= nums[mid]) {
                // If the target exists in the first section, we don't need the second half anymore
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    // If the target is not here, we don't need the first half
                    left = mid + 1;
                }
            } else {
                // The section has to be sorted here since the first case failed
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println(search(nums, target));
    }
}
