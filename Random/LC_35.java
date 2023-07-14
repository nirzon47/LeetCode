// https://leetcode.com/problems/search-insert-position/

public class LC_35 {
    public static int searchInsert(int[] nums, int target) {
        // Applying normal binary search
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // We are returning left because we want the position just after
        // our closest element to target.
        // Returning right would give one index less since in case the element is not
        // present, left surpasses right by just one.
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 2));
    }
}
