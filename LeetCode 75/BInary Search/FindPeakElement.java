// https://leetcode.com/problems/find-peak-element/

public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        // Implementing binary search
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // If nums[mid] is greater than the element after it, we are not at the max yet, same for the else part
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
            // We are converging our solution until the left and right both points to the peak
        }
        
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};

        System.out.println(findPeakElement(nums));
    }
}
