public class LC_189 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        int lIndex = nums.length - 1;
        k = k % nums.length;

        reverse(nums, 0, lIndex);
        reverse(nums, 0, k - 1);
        reverse(nums, k, lIndex);

    }

    static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
