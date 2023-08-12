// https://leetcode.com/problems/valid-mountain-array/

public class LC_941 {
    public static boolean validMountainArray(int[] nums) {
        int i = 0, len = nums.length;
        // loop goes until we are in the ascending part
        for (; i < len - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                break;
            }
        }

        // If loop broke at the first element or the last element, this is no mountain, just a cliff
        if (i == 0 || i == len - 1) {
            return false;
        }

        // loop goes until descending part
        for (; i < len - 1; i++) {
            // If at any point, we start ascending again, we return false
            if (nums[i] <= nums[i + 1]) {
                return false;
            }
        }

        // Otherwise, returns true
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{3, 5, 5}));
    }
}
