public class LC_80 {
    public static int removeDuplicates(int[] nums) {
        // We are already counting the first element
        int pointer = 1, count = 1;

        for (int i = 1; i < nums.length; i++) {
            // If the current number is the same as the number before it, we increase our count
            if (nums[i] == nums[i - 1]) {
                // If 'count' is less than 2, we put the current number in the array in order
                if (count < 2) {
                    nums[pointer++] = nums[i];
                }
                count++;
            }
            // If the numbers are different, we reinitialize everything for the new number
            else {
                count = 1;
                nums[pointer++] = nums[i];
            }
        }

        return pointer;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int k = removeDuplicates(nums);

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
