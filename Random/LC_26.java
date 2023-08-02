// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class LC_26 {
    public static int removeDuplicates(int[] nums) {
        int count = 1;

        // Ignoring the first element because we are assuming it to be unique
        // Also because our checks cannot work for i = 0
        for (int i = 1; i < nums.length; i++) {
            // If the elements are different, we put the different element
            // in count's position and also increase count
            if (nums[i] != nums[i - 1]) {
                nums[count++] = nums[i];
            }
        }

        // Count holds the number of unique elements
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int limit = removeDuplicates(nums);

        for (int i = 0; i < limit; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
