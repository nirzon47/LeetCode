import java.util.*;

public class LC_976 {
    public static int largestPerimeter(int[] nums) {
        // We sort the array
        Arrays.sort(nums);

        // We descend through the array until 2nd index
        for (int i = nums.length - 1; i > 1; i--) {
            // If the largest size is smaller than the sum of the other two sides, we return that sum
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }

        // If nothing like this is found, we return 0
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{1, 2, 1, 10}));
    }
}
