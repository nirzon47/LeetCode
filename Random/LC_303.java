// https://leetcode.com/problems/range-sum-query-immutable/

public class LC_303 {
    static int[] nums; // global array to store the prefix sum

    public static void main(String[] args) {
        LC_303 obj = new LC_303();
        obj.NumArray(new int[]{-2, 0, 3, -5, 2, -1});

        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }

    public void NumArray(int[] numbers) {
        // Making a prefix sum array which is one length more than the given array
        nums = new int[numbers.length + 1];

        for (int i = 0; i < numbers.length; i++) {
            // We are storing the prefix sum one place higher than the actual index it should be
            // because the first value is a fake value and makes us skip a condition
            nums[i + 1] = nums[i] + numbers[i];
        }
    }

    public int sumRange(int left, int right) {
        // The result is the prefix array at right + 1 - prefix array at left
        return nums[right + 1] - nums[left];
    }
}
