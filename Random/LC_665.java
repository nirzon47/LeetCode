// https://leetcode.com/problems/non-decreasing-array/

public class LC_665 {
    public static boolean checkPossibility(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                // If an exception appears, we keep a count of it
                count++;

                // If the element that is 2 steps before the current element is less than or equal,
                // We modify the array to make it in ascending order
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }

            // If we modified it twice or an exception is found twice, its no longer possible to make this array
            // ascending with just one step
            if (count > 1) {
                return false;
            }
        }

        // If everything is alright, returns true
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4, 2, 3}));
    }
}
