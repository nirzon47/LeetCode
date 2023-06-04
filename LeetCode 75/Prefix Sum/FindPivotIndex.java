// https://leetcode.com/problems/find-pivot-index/

public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {
        int lSum = 0, rSum = 0, len = nums.length;

        // Storing the sum of all elements except the first element
        for (int i = 1; i < len; i++) {
            rSum += nums[i];
        }
        // If the sum we just found out is 0, that means 0 is the pivot index since there is nothing on the left of 0
        if (rSum == lSum)
            return 0;

        // Finding the sum of the next leftSum and rightSum and returning the index if its equal of both sums
        for (int i = 1; i < len; i++) {
            rSum -= nums[i];
            lSum += nums[i - 1];
            if (lSum == rSum)
                return i;
        }

        // -1 is the default return value if there is no pivot
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }
}
